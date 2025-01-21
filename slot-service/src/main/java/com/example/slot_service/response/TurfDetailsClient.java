package com.example.slot_service.response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "turf-service")
public interface TurfDetailsClient {

    @GetMapping("/getTurf/{id}")
    TurfDetailsResponse getTurfDetails(@PathVariable("id") Long turfId);
}
