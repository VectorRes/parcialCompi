package com.compi.elitewings.service;

import com.compi.elitewings.models.Flight;

import java.util.List;
import java.util.Optional;

public interface IServiceFlight {
    Flight createFlight(Flight flight);
    Optional<Flight> getFlight(int id);
    List<Flight> getSuspiciousFlights();
    void deleteFlight(int id);
}
