package com.compi.elitewings.Controllers;

import com.compi.elitewings.models.Flight;
import com.compi.elitewings.service.IServiceFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private IServiceFlight serviceFlight;

    @GetMapping("/")
    public List<Flight> index() {
        return this.serviceFlight.getFlights();
    }

    @GetMapping("/flights/{id}")
    public Flight getFlight(@PathVariable("id") long id){
        return this.serviceFlight.getFlight(id).orElse(null);
    }

    @GetMapping("/flights/{id}")
    public Flight getSuspiciousFlight(@PathVariable("id") long id){
        return (Flight) this.serviceFlight.getSuspiciousFlights();
    }

    @PostMapping("/flights")
    public Flight createCelebrity(@RequestBody Flight flight){
        this.serviceFlight.createFlight(flight);
        return flight;

    }

    @DeleteMapping("/flights/{id}")
    public String deleteFlight(@PathVariable("id") long id){
        try {
            this.serviceFlight.deleteFlight(id);
            return "flight with id " + id + " deleted successfully";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

}


