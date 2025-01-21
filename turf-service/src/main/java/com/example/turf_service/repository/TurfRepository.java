package com.example.turf_service.repository;

import com.example.turf_service.entity.TurfDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurfRepository extends JpaRepository<TurfDetails,Long> {
}
