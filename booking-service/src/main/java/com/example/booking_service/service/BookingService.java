package com.example.booking_service.service;

import com.example.booking_service.clients.Slot;
import com.example.booking_service.clients.SlotClient;
import com.example.booking_service.entity.Booking;
import com.example.booking_service.entity.NotificationMessage;
import com.example.booking_service.repository.BookingRepository;
import com.example.booking_service.response.response.BookingMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@Service
public class BookingService {

    private static final String TOPIC1 = "booking-slotupdate";
    private static final String TOPIC2 = "booking-slotdelete";

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SlotClient slotClient;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private NotificationService notificationService;
    //private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    public String bookSlot(Booking bookingDetails, long userId, long slotId) throws JsonProcessingException {
        //logger.debug("Received booking request: {}", bookingDetails);
        //logger.debug("User ID: {}, Slot ID: {}", userId, slotId);

        Slot slotAvailabile=slotClient.getSlotById(slotId).getBody();
        if(Objects.nonNull(slotAvailabile)){
            Booking booked=bookingRepository.findBySlotId(slotId);
            if(!Objects.nonNull(booked)){
                bookingRepository.save(bookingDetails);

                //DTO
                BookingMessage bm=new BookingMessage(slotId,userId);
                //converting the object into json string....
                kafkaTemplate.send(TOPIC1,new ObjectMapper().writeValueAsString(bm));

                notificationService.notifyUser(new NotificationMessage(userId,slotAvailabile.getTurfId(),slotId,"Congraluation the booking has been confirmed for you!!!"));
                notificationService.notifyTurf(new NotificationMessage(userId,slotAvailabile.getTurfId(),slotId,"The user has been booked the slot "+ slotId+" in your turf"));

                return "booked successfully!!";
            }
            return "Already booked ";
        }else {
            return "Slot with that id is not available";
        }
    }

    public void deleteById(long bookingId) throws JsonProcessingException {
        Booking booking=bookingRepository.findById(bookingId).orElse(null);
        if(booking!=null){
            long slotId=booking.getSlotId();
            long userId=booking.getUserId();
            bookingRepository.deleteById(bookingId);
            BookingMessage bm=new BookingMessage(slotId,userId);
            kafkaTemplate.send(TOPIC2,new ObjectMapper().writeValueAsString(bm));      }
    }
}
