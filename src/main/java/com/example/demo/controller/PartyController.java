package com.example.demo.controller;

import com.example.demo.entity.Party;
import com.example.demo.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/parties")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @GetMapping
    public List<Party> getAllParties() {
        return partyService.getAllParties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Party> getPartyById(@PathVariable UUID id) {
        Optional<Party> party = partyService.getPartyById(id);
        return party.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Party createParty(@RequestBody Party party) {
        return partyService.createParty(party);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Party> updateParty(@PathVariable UUID id, @RequestBody Party updatedParty) {
        Party party = partyService.updateParty(id, updatedParty);
        return ResponseEntity.ok(party);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParty(@PathVariable UUID id) {
        partyService.deleteParty(id);
        return ResponseEntity.noContent().build();
    }
}
