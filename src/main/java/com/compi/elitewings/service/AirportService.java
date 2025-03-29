package com.compi.elitewings.service;

import com.compi.elitewings.models.Airport;
import com.compi.elitewings.repository.IAirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AirportService implements IServiceAirport {

    private final IAirportRepository airportRepository;

    @Autowired
    public AirportService(IAirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<Airport> getAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> getAirport(long id) {
        return airportRepository.findById(id);
    }
}
