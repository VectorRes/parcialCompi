package com.compi.elitewings.service;

import com.compi.elitewings.models.Celebrity;

import java.util.List;
import java.util.Optional;

public interface IServiceCelebrity {
    public void addCelebrity(Celebrity celebrity);
    public Optional<Celebrity> getCelebrity(long id);
    public List<Celebrity> getCelebrities();
    public void deleteCelebrity(long id);
    public void updateCelebrity(Celebrity celebrity);
}
