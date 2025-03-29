package com.compi.elitewings.Controllers;

import com.compi.elitewings.models.Celebrity;
import com.compi.elitewings.service.IServiceCelebrity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/celebrities")
public class CelebrityController {
    @Autowired
    private IServiceCelebrity serviceCelebrity;

    @GetMapping("/")
    public List<Celebrity> index(){return this.serviceCelebrity.getCelebrities();}
    @GetMapping("/celebrities/{id}")
    public Celebrity getCelebrity(@PathVariable("id") long id){
        return this.serviceCelebrity.getCelebrity(id).orElse(null);
    }

    @PostMapping("/celebrities")
    public Celebrity createCelebrity(@RequestBody Celebrity celebrity){
        this.serviceCelebrity.addCelebrity(celebrity);
        return celebrity;
    }

    @DeleteMapping("/celebrities/{id}")
    public String deleteCelebrity(@PathVariable("id") long id){
        try {
            this.serviceCelebrity.deleteCelebrity(id);
            return "Celebrity with ID " + id + " deleted successfully.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }


    @PutMapping("/celebrities/{id}")
    public String updateCelebrity(@PathVariable("id") long id, @RequestBody Celebrity celebrity){
        try {
            celebrity.setId((int) id);
            this.serviceCelebrity.updateCelebrity(celebrity);
            return "Celebrity with ID " + id + " updated successfully.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }





}
