package com.example.booking_service.clients;

import java.time.LocalDateTime;

public class Slot {
    private long slotId;
    private LocalDateTime startingTime;
    private LocalDateTime endingTime;
    private long turfId;

    public Slot(long slotId, LocalDateTime startingTime, LocalDateTime endingTime,long turfId) {
        this.slotId = slotId;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.turfId=turfId;
    }

    public Slot() {
    }

    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalDateTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime) {
        this.endingTime = endingTime;
    }

    public long getTurfId() {
        return turfId;
    }

    public void setTurfId(long turfId) {
        this.turfId = turfId;
    }
}
