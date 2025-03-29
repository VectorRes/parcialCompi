package com.compi.elitewings.Controllers;


import com.compi.elitewings.models.PrivateJet;
import com.compi.elitewings.service.IServicePrivateJet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/privateJets")
public class PrivateJetController {
    @Autowired
    private IServicePrivateJet servicePrivateJet;

    @GetMapping("/")
    public List<PrivateJet> index(){return this.servicePrivateJet.getPrivateJets();}

    @GetMapping("/privateJets/{id}")
    public PrivateJet getPrivateJet(@PathVariable("id") long id){
        return this.servicePrivateJet.getPrivateJet(id).orElse(null);
    }

    @PostMapping("/privateJets/{id}")
    public PrivateJet createPrivateJet(@RequestBody PrivateJet privateJet){
        this.servicePrivateJet.addPrivateJet(privateJet);
        return privateJet;
    }

    @DeleteMapping("/privateJets/{id}")
    public String deletePrivateJet(@PathVariable("id") long id){
        try {
            this.servicePrivateJet.deletePrivateJet(id);
            return "PrivateJet with ID " + id + " deleted successfully.";
        }catch (RuntimeException e){
            return e.getMessage();
        }
    }

    @PutMapping("/privateJets/{id}")
    public String updatePrivateJet(@PathVariable("id") long id, @RequestBody PrivateJet privateJet){
        try {
            privateJet.setId((int) id);
            this.servicePrivateJet.updatePrivateJet(privateJet);
            return "PrivateJet with ID " + id + " updated successfully.";
        } catch (RuntimeException e) {
            return e.getMessage();

        }
    }
}
