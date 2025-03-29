package com.compi.elitewings.repository;

import com.compi.elitewings.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAirportRepository extends JpaRepository<Airport, Long> {

}
