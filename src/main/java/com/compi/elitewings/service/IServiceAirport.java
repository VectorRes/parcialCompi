package com.compi.elitewings.service;

import com.compi.elitewings.models.Airport;
import java.util.List;
import java.util.Optional;

public interface IServiceAirport {
    List<Airport> getAirports();
    Optional<Airport> getAirport(long id);
}
