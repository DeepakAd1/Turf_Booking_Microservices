package com.example.slot_service.response;

import com.example.slot_service.entity.Slot;

public class SlotResponse {
    private Slot slot;
    private TurfDetailsResponse turfDetailsResponse;

    public SlotResponse(Slot slot, TurfDetailsResponse turfDetailsResponse) {
        this.slot = slot;
        this.turfDetailsResponse = turfDetailsResponse;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public TurfDetailsResponse getTurfDetailsResponse() {
        return turfDetailsResponse;
    }

    public void setTurfDetailsResponse(TurfDetailsResponse turfDetailsResponse) {
        this.turfDetailsResponse = turfDetailsResponse;
    }
}
