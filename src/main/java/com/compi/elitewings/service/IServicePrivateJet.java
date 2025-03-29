package com.compi.elitewings.service;

import com.compi.elitewings.models.PrivateJet;

import java.util.List;
import java.util.Optional;

public interface IServicePrivateJet {
    public void addPrivateJet(PrivateJet privateJet);
    public Optional<PrivateJet> getPrivateJet(long id);
    public List<PrivateJet> getPrivateJets();
    public void deletePrivateJet(long id);
    public void updatePrivateJet(PrivateJet privateJet);
}
