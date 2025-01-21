package com.example.slot_service.service;
import com.example.slot_service.response.*;
import com.example.slot_service.repository.SlotRepository;

import com.example.slot_service.entity.Slot;
import com.example.slot_service.response.TurfDetailsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private TurfDetailsClient turfDetailsClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    public SlotResponse createOrUpdateSlot(Slot slot) {
        // Check if the TurfDetails entity with the given ID exists in the database

        System.out.println("Entered.....................");
        TurfDetailsResponse turfDetailsResponse=null;
        try{
            turfDetailsResponse=turfDetailsClient
                                    .getTurfDetails(slot.getTurfId());
            System.out.println("Entered.....................");
        }catch (Exception e){
            System.out.print("turf with the id "+ slot.getTurfId()+" is not available..");
        }
        // Now save the Slot object
        slotRepository.save(slot);
        return new SlotResponse(slot,turfDetailsResponse);
    }


    // Get all Slots
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    // Get Slot by ID
    public Slot getSlotById(Long id) {
        return slotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slot not found with id: " + id));
    }

    // Delete Slot by ID
    public void deleteSlot(Long id) {
        Slot slot = getSlotById(id);
        slotRepository.delete(slot);
    }

    public String getSlotStatus(long id) {
        Slot slot=slotRepository.findById(id).orElse(null);
        if(slot!=null){
            if(slot.getIsBooked()==0){
                return "The slot with id"+id+" is free";
            }
            return "the slot is booked already...";
        }
        return "no slot with the id "+id+" is founded";
    }

    public List<Slot> getFreeSlots(long turfId) {
        List<Slot> allSlots=slotRepository.findByTurfId(turfId);
        List<Slot> freeSlots=new ArrayList<>();
        for(Slot slot:allSlots){
            if(slot.getIsBooked()==0) freeSlots.add(slot);
        }
        return freeSlots;
    }

    @KafkaListener(topics = "booking-slotupdate",groupId = "group_id")
    public void consume(String message) throws JsonProcessingException {
        System.out.println("booking created and the slot service recieved the message..............");
        BookingMessage bm=objectMapper.readValue(message,BookingMessage.class);
        long slotId=bm.getSlotId();
        System.out.println("slotId"+slotId);
        Slot slot=slotRepository.findById(slotId).orElse(null);
        if(slot!=null){
            slot.setIsBooked(1);
            slotRepository.save(slot);
        }else{
            System.out.println("No slot has founded with that Id..");
        }

    }

    @KafkaListener(topics = "booking-slotdelete",groupId = "group_id")
    public void listen(String message) throws JsonProcessingException {
        System.out.println("Slot updating after deleting.....................");
        BookingMessage bm=objectMapper.readValue(message,BookingMessage.class);
        long slotId=bm.getSlotId();
        System.out.println("slotId"+slotId);
        Slot slot=slotRepository.findById(slotId).orElse(null);
        if(slot!=null){
            slot.setIsBooked(0);
            slotRepository.save(slot);
        }else{
            System.out.println("No slot has founded with that Id..");
        }
    }
}


