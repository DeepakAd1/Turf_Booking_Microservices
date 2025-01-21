package com.example.booking_service.controller;

import com.example.booking_service.entity.Booking;
import com.example.booking_service.service.BookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book/{userId}/{slotId}")
    public String bookingSlot(@RequestBody Booking bookingDetails,
                              @PathVariable("userId") long userId,
                              @PathVariable("slotId") long slotId) throws JsonProcessingException {
        return bookingService.bookSlot(bookingDetails,userId,slotId);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable("bookingId") long bookingId) throws JsonProcessingException {
        bookingService.deleteById(bookingId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully!!");
    }
}
