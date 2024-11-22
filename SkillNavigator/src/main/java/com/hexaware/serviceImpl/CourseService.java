package com.hexaware.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.model.Candidate;
import com.hexaware.model.Course;
import com.hexaware.repository.CandidateRepository;
import com.hexaware.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
    private CandidateRepository candidateRepository;
	
	 Map<Course, Map<String, String>> outerMap = new HashMap<>();
	 private long score=0;
	
	public Course updateCompletionStatus(Long id, boolean isCompleted) {
		// TODO Auto-generated method stub
		Course existingcourse= courseRepository.findById(id).get();
		existingcourse.setCompleted(isCompleted);
		return courseRepository.save(existingcourse);
	}


	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		outerMap.put(course,course.getTestmap());
		return courseRepository.save(course);
	}


	public Course assignCandidate(long id,long courseId) {
		Candidate candidate=candidateRepository.findById(id).get();
		Course course=courseRepository.findById(courseId).get();
		course.getCandidates().add(candidate);
		
		return courseRepository.save(course);
	}
    
	
	public Long calculateScore(long id,Map<String,String> userAnswers)
	{
		score=0;
		for(Map.Entry<Course,Map<String,String>> mp: outerMap.entrySet())
		{
			Course key=mp.getKey();
			Map<String,String> innerMap=mp.getValue();
			if(key.getId()==id)
			{
				for(Map.Entry<String,String> m: innerMap.entrySet())
				{
					if(m.getValue().equals(userAnswers.get(m.getKey())))
					{
						score++;
					}
				}
			}
			
		}
		 return score;
	}
	
	 
	
}
