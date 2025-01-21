package com.example.booking_service.entity;

import org.springframework.stereotype.Component;

@Component
public class NotificationMessage {
    private long userId;
    private long turfId;
    private long slotId;
    private String message;

    public NotificationMessage(long userId, long turfId, long slotId,String message) {
        this.userId = userId;
        this.turfId = turfId;
        this.slotId = slotId;
        this.message=message;
    }

    public NotificationMessage() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTurfId() {
        return turfId;
    }

    public void setTurfId(long turfId) {
        this.turfId = turfId;
    }

    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NotificationMessage{" +
                "userId=" + userId +
                ", turfId=" + turfId +
                ", slotId=" + slotId +
                ", message='" + message + '\'' +
                '}';
    }
}
