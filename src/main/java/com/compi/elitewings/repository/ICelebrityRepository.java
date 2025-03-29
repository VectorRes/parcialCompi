package com.compi.elitewings.repository;

import com.compi.elitewings.models.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICelebrityRepository extends JpaRepository<Celebrity,Long> {
    public Optional<Celebrity> findById(long id);
    public List<Celebrity> findByIdContaining(long id);
    public List<Celebrity> deleteCelebrity(long id);
    public List<Celebrity> deleteCelebrityContaining(long id);
    public List<Celebrity> addCelebrity(Celebrity celebrity);
    public List<Celebrity> updateCelebrity(Celebrity celebrity);

}
