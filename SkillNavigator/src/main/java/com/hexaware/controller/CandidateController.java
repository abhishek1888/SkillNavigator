package com.hexaware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.model.Candidate;
import com.hexaware.serviceImpl.CandidateService;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
 
    @GetMapping("/getall")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidate());
    }
 
    @PostMapping("/create")
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        return ResponseEntity.ok(candidateService.saveCandidate(candidate));
    }
    
    @PostMapping("/assign")
    public ResponseEntity<Candidate> assignCandidateBatch(@RequestParam long id) {
        return ResponseEntity.ok(candidateService.assignCandidate(id));
    }
    
    @GetMapping("/getbyId")
    public ResponseEntity<Candidate> getCandidateById(@RequestParam Long id)
    {
    	return ResponseEntity.ok(candidateService.findCandidateById(id));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Candidate> updateCandidate(@RequestParam Long id, @RequestBody Candidate candidateDetails) {
        Candidate updatedCandidate = candidateService.update(id, candidateDetails);
        return ResponseEntity.ok(updatedCandidate);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCandidate(@RequestParam Long id) {
        candidateService.delete(id);
        return ResponseEntity.noContent().build();
    }
    // Additional endpoints for CRUD operations
}
