package com.example.slot_service.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "slot_seq")
    @SequenceGenerator(name="slot_seq",sequenceName = "SLOT_SEQ",allocationSize = 1)
    private Long id;

    private LocalDateTime startTime; // Example: "10:00 AM"
    private LocalDateTime endTime;   // Example: "11:00 AM"
    private long turfId;
    private long isBooked;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Slot() {
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public long getTurfId() {
        return turfId;
    }

    public void setTurfId(long turfId) {
        this.turfId = turfId;
    }

    public long getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(long isBooked) {
        this.isBooked = isBooked;
    }

    public Slot(Long id, LocalDateTime startTime, LocalDateTime endTime,long turfId,long isBooked) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.turfId=turfId;
        this.isBooked=0;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", turfId=" + turfId +
                ", isBooked=" + isBooked +
                '}';
    }
}

