package com.hexaware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.model.Batch;
import com.hexaware.model.Candidate;
import com.hexaware.serviceImpl.BatchService;
import com.hexaware.serviceImpl.CandidateService;

@RestController
@RequestMapping("/api/batches")
public class BatchController {
     
	@Autowired
    private BatchService batchService;
	
	
	 
	@PostMapping("/create")
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch) {
        return ResponseEntity.ok(batchService.saveBatch(batch));
    }
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> removeCandidateFromBatch(@RequestParam long id,@RequestParam long batchId)
	{
		batchService.removeCandidateFromBatch(id,batchId);
		return ResponseEntity.ok("Candidate is removed from batch");
	}
	
}
