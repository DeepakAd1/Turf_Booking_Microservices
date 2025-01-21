package com.example.slot_service.repository;

import java.util.List;
import com.example.slot_service.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot,Long> {
    List<Slot> findByTurfId(long turfId);
}
