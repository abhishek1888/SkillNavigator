package com.hexaware.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.model.Batch;
import com.hexaware.model.Candidate;
import com.hexaware.repository.BatchRepository;
import com.hexaware.repository.CandidateRepository;

@Service
public class BatchService {

	
	@Autowired
	private BatchRepository batchrepository;
	
	@Autowired
    private CandidateRepository candidateRepository;
	
	
	private Candidate candidate;

	public Batch saveBatch(Batch batch) {
		
		return batchrepository.save(batch);
	}
	
	public void removeCandidateFromBatch(long id,long batchId)
	{
		Batch existingBatch=batchrepository.findById(batchId).get();
		Candidate tempcandidate=null;
		for(Candidate candidate: existingBatch.getCandidates())
		{
			if(candidate.getId()==id)
			{
				tempcandidate=candidate;
				break;
			}
		}
		existingBatch.getCandidates().remove(tempcandidate);
		tempcandidate.setBatch(null);
         // Save the updated candidate to the repository
         candidateRepository.save(tempcandidate);
		return;
	}
     
	
	
}
