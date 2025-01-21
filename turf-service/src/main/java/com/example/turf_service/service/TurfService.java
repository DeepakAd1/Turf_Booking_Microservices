package com.example.turf_service.service;
import com.example.turf_service.entity.TurfDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;


public interface TurfService {
    public List<TurfDetails> fetchTurfList();

    public TurfDetails findTurfById(long id);

    public TurfDetails save(TurfDetails turfDetails);

    public boolean deleteTurfById(long id);

    public TurfDetails updateTurfById(long id, TurfDetails turfDetails);
}
