package com.example.slot_service.response;

public class BookingMessage {
    private long slotId;
    private long userId;

    // Getters and Setters
    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BookingMessage() {
    }

    public BookingMessage(long slotId, long userId) {
        this.slotId = slotId;
        this.userId = userId;
    }
}

