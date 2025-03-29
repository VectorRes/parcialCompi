package com.compi.elitewings.service;

import com.compi.elitewings.models.Flight;
import com.compi.elitewings.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService implements IServiceFlight {

    private final IFlightRepository flightRepository;

    @Autowired
    public FlightService(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> getFlight(long id) {
        return flightRepository.findById(id);
    }

    @Override
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> getSuspiciousFlights() {
        return flightRepository.findByPurpose(Flight.Purpose.SUSPICIOUS);
    }

    @Override
    public void deleteFlight(long id) {
        flightRepository.deleteById(id);
    }

}
