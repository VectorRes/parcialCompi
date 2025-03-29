package com.compi.elitewings.repository;

import com.compi.elitewings.models.PrivateJet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPrivateJetRepository extends JpaRepository<PrivateJet,Long> {
    public Optional<PrivateJet> findById(long id);
    public List<PrivateJet> findByIdContaining(long id);
    public List<PrivateJet> deletePrivateJet(long id);
    public List<PrivateJet> deletePrivateJetContaining(long id);
    public List<PrivateJet> addPrivateJet(PrivateJet privateJet);
    public List<PrivateJet> updatePrivateJet(PrivateJet privateJet);
}
