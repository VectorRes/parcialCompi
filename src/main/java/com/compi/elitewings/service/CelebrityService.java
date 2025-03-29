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

    }

    @Override
    public void updateCelebrity(Celebrity celebrity) {

    }


}
