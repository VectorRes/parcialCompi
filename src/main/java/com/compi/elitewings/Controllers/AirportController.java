package com.compi.elitewings.Controllers;

import com.compi.elitewings.models.Airport;
import com.compi.elitewings.service.IServiceAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/airports")

public class AirportController {
    @Autowired
    private IServiceAirport serviceAirport;

    @GetMapping("/airports")
    public List<Airport> index(){return this.serviceAirport.getAirports();}
    @GetMapping("/airports/{id}")
    public Airport getAirport(@PathVariable("id") long id){
        return this.serviceAirport.getAirport(id).orElse(null);
    }
}
