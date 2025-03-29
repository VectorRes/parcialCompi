package com.compi.elitewings.service;

import com.compi.elitewings.models.PrivateJet;
import com.compi.elitewings.repository.IPrivateJetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivateJetService implements IServicePrivateJet{
    @Autowired
    private IPrivateJetRepository privateJetRepository;

    @Override
    public void addPrivateJet(PrivateJet privateJet){

    }

    @Override
    public Optional<PrivateJet> getPrivateJet(long id) {
        return this.privateJetRepository.findById(id);
    }

    @Override
    public List<PrivateJet> getPrivateJets(){ return privateJetRepository.findAll(); }

    @Override
    public void deletePrivateJet(long id) {

    }

    @Override
    public void updatePrivateJet(PrivateJet privateJet){

    }
}
