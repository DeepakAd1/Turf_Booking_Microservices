package com.example.slot_service.response;

public class TurfDetailsResponse {
    private long turfId;
    private String turfName;
    private String emailId;
    private String turfLocation;

    // Getters and Setters
    public long getTurfId() {
        return turfId;
    }

    public void setTurfId(long turfId) {
        this.turfId = turfId;
    }

    public String getTurfName() {
        return turfName;
    }

    public void setTurfName(String turfName) {
        this.turfName = turfName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getTurfLocation() {
        return turfLocation;
    }

    public void setTurfLocation(String turfLocation) {
        this.turfLocation = turfLocation;
    }
}
