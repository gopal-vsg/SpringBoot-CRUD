package com.example.demo.service;

import com.example.demo.entity.Party;
import com.example.demo.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    public Optional<Party> getPartyById(UUID id) {
        return partyRepository.findById(id);
    }

    public Party createParty(Party party) {
        return partyRepository.save(party);
    }

    public Party updateParty(UUID id, Party updatedParty) {
        return partyRepository.findById(id)
                .map(party -> {
                    party.setName(updatedParty.getName());
                    party.setEmail(updatedParty.getEmail());
                    party.setAddress(updatedParty.getAddress());
                    party.setContact(updatedParty.getContact());
                    return partyRepository.save(party);
                })
                .orElseThrow(() -> new RuntimeException("Party not found with id " + id));
    }

    public void deleteParty(UUID id) {
        partyRepository.deleteById(id);
    }
}
