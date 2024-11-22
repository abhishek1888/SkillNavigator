package com.hexaware.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.model.Batch;
import com.hexaware.model.Candidate;
import com.hexaware.repository.BatchRepository;
import com.hexaware.repository.CandidateRepository;
import java.util.Random;

@Service
public class CandidateService
{
    @Autowired
    private CandidateRepository candidateRepository;
 
    @Autowired
    private BatchRepository batchRepository;
    
    private Random random=new Random();
    
    public List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }
 
    public Candidate saveCandidate(Candidate candidate) {
    	
    	 int javaCertCount = countJavaCertifications(candidate);
         int dotNetCertCount = countDotNetCertifications(candidate);
         int pythonCertCount = countPythonCertifications(candidate);

         // Determine the batch based on the highest number of certifications
         if (javaCertCount > dotNetCertCount && javaCertCount > pythonCertCount) {
             assignToBatch(candidate, "Java Batch");
         } else if (dotNetCertCount > javaCertCount && dotNetCertCount > pythonCertCount) {
             assignToBatch(candidate, ".NET Batch");
         } else if (pythonCertCount > javaCertCount && pythonCertCount > dotNetCertCount) {
             assignToBatch(candidate, "Python Batch");
         } else {
             // In case of a tie, assign randomly
             String[] batchNames = {"Java Batch", ".NET Batch", "Python Batch"};
             String randomBatch = batchNames[random.nextInt(batchNames.length)];
             assignToBatch(candidate, randomBatch);
         }
    	  
    	  
        return candidateRepository.save(candidate);
    }
    public Candidate assignCandidate(long id) {
		
    	Candidate candidate=candidateRepository.findById(id).get();
    	int javaCertCount = countJavaCertifications(candidate);
        int dotNetCertCount = countDotNetCertifications(candidate);
        int pythonCertCount = countPythonCertifications(candidate);

        // Determine the batch based on the highest number of certifications
        if (javaCertCount > dotNetCertCount && javaCertCount > pythonCertCount) {
            assignToBatch(candidate, "Java Batch");
        } else if (dotNetCertCount > javaCertCount && dotNetCertCount > pythonCertCount) {
            assignToBatch(candidate, ".NET Batch");
        } else if (pythonCertCount > javaCertCount && pythonCertCount > dotNetCertCount) {
            assignToBatch(candidate, "Python Batch");
        } else {
            // In case of a tie, assign randomly
            String[] batchNames = {"Java Batch", ".NET Batch", "Python Batch"};
            String randomBatch = batchNames[random.nextInt(batchNames.length)];
            assignToBatch(candidate, randomBatch);
        }
   	  
   	  
       return candidateRepository.save(candidate);
	}
    
    public Candidate findCandidateById(Long id)
    {
    	Candidate newcandidate= candidateRepository.findById(id).get();
    	return newcandidate;
    }

	public Candidate update(Long id, Candidate candidateDetails) {
		// TODO Auto-generated method stub
		Candidate existingCandidate = candidateRepository.findById(id).get();
		
		// Update the existing candidate's details with the new details
	    existingCandidate.setName(candidateDetails.getName());
	    existingCandidate.setEmail(candidateDetails.getEmail());
	    existingCandidate.setPhone(candidateDetails.getPhone());
	    existingCandidate.setEducation(candidateDetails.getEducation());
	    existingCandidate.setFeedbacks(candidateDetails.getFeedbacks());
	    existingCandidate.setFileUploads(candidateDetails.getFileUploads());

	    // Save the updated candidate back to the repository
	    return candidateRepository.save(existingCandidate);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		candidateRepository.deleteById(id);
	}
  
	// Count Java-related certifications
    private int countJavaCertifications(Candidate candidate) {
        return (int) candidate.getEducation().stream()
                .filter(cert -> cert.contains("AWS")|| cert.contains("Java"))
                .count();
    }

    // Count .NET-related certifications
    private int countDotNetCertifications(Candidate candidate) {
        return (int) candidate.getEducation().stream()
                .filter(cert -> cert.contains("Azure")|| cert.contains(".NET"))
                .count();
    }

    // Count Data Engineering-related certifications
    private int countPythonCertifications(Candidate candidate) {
        return (int) candidate.getEducation().stream()
                .filter(cert -> cert.contains("Python"))
                .count();
    }

    // Assign candidate to a batch if it meets the criteria
    private void assignToBatch(Candidate candidate, String batchName) 
    {
        for (Batch batch : batchRepository.findAll()) 
        {
            if (batch.getName().equals(batchName) && batch.getCandidates().size() < 30) 
            {
                batch.getCandidates().add(candidate);
                candidate.setBatch(batch);
                System.out.println("Candidate assigned to " + batchName);
                return;
            }
        }
    }
    

	
}

