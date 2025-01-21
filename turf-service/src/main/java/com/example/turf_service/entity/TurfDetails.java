package com.example.turf_service.entity;
import jakarta.persistence.*;
import java.io.Serializable;


@Entity
public class TurfDetails implements Serializable {

    @Id
    @SequenceGenerator(name="turf_seq",sequenceName = "TURF_SEQ",allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "turf_seq")
    private long turfId;
    private String turfName;
    private String emailId;
    private String turfLocation;


    public TurfDetails(long turfId, String turfName, String emailId, String turfLocation) {
        this.turfId = turfId;
        this.turfName = turfName;
        this.emailId = emailId;
        this.turfLocation = turfLocation;

    }

    public TurfDetails() {
    }

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

