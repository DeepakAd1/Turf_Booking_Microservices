package com.example.slot_service.controller;
import com.example.slot_service.response.SlotResponse;
import com.example.slot_service.response.TurfDetailsResponse;
import com.example.slot_service.service.SlotService;
import com.example.slot_service.entity.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    @Autowired
    private SlotService slotService;

    // Create or Update Slot
    @PostMapping
    public ResponseEntity<SlotResponse> createOrUpdateSlot(@RequestBody Slot slot) {
        SlotResponse savedSlot = slotService.createOrUpdateSlot(slot);
        return ResponseEntity.ok(savedSlot);
    }

    // Get All Slots
    @GetMapping
    public ResponseEntity<List<Slot>> getAllSlots() {
        List<Slot> slots = slotService.getAllSlots();
        return ResponseEntity.ok(slots);
    }

    // Get Slot by ID
    @GetMapping("/{id}")
    public ResponseEntity<Slot> getSlotById(@PathVariable Long id) {
        Slot slot = slotService.getSlotById(id);
        return ResponseEntity.ok(slot);
    }

    @GetMapping("/status/{id}")
    public String getSlotStatus(@PathVariable long id){
        return slotService.getSlotStatus(id);
    }

    // Delete Slot by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSlot(@PathVariable Long id) {
        slotService.deleteSlot(id);
        return ResponseEntity.ok("Slot deleted successfully");
    }

    @GetMapping("/getFreeSlots/{id}")
    @ResponseBody
    public List<Slot> getFreeSlots(@PathVariable long id){
        return slotService.getFreeSlots(id);
    }
}
