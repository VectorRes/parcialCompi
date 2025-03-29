package com.compi.elitewings.service;

import com.compi.elitewings.models.Celebrity;
import com.compi.elitewings.repository.ICelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CelebrityService implements  IServiceCelebrity{
    @Autowired
    private ICelebrityRepository celebrityRepository;

    @Override
    public void addCelebrity(Celebrity celebrity) {
        celebrityRepository.save(celebrity);

    }

    @Override
    public Optional<Celebrity> getCelebrity(long id) {
        return this.celebrityRepository.findById(id);
    }

    @Override
    public List<Celebrity> getCelebrities() {
        return celebrityRepository.findAll();
    }

    @Override
    public void deleteCelebrity(long id) {
        if(this.celebrityRepository.existsById(id)) {
            this.celebrityRepository.deleteById(id);
        } else {
            throw new RuntimeException("Celebrity not found with id: " + id);
        }

    }

    @Override
    public void updateCelebrity(Celebrity celebrity) {
        if(celebrityRepository.existsById((long) celebrity.getId())) {
            this.celebrityRepository.save(celebrity);
        }else {
            throw new RuntimeException("Celebrity not found with id: " + celebrity.getId());
        }

    }

}
