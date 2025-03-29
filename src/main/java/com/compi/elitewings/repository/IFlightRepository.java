package com.compi.elitewings.repository;

import com.compi.elitewings.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByPurpose(Flight.Purpose purpose);
}
