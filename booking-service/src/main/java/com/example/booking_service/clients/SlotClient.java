package com.example.booking_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "slot-service")
public interface SlotClient {

    @GetMapping("/api/slots/{id}")
    public ResponseEntity<Slot> getSlotById(@PathVariable Long id);
}
