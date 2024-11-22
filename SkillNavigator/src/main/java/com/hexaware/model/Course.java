package com.hexaware.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexaware.helper.MapToJsonConverter;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
 
    @ManyToMany
    @JoinTable(
      name = "course_candidate", 
      joinColumns = @JoinColumn(name = "course_id"), 
      inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    private List<Candidate> candidates;
    
    private boolean isCompleted=false;

    @Convert(converter = MapToJsonConverter.class)
    private Map<String,String> testmap=new HashMap<String,String>();
    
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Long id, String name, String description, List<Candidate> candidates,boolean isCompleted,Map<String,String> testmap) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.candidates = candidates;
		this.isCompleted=isCompleted;
		this.testmap=testmap;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	
	public Map<String, String> getTestmap() {
		return testmap;
	}

	public void setTestmap(Map<String, String> testmap) {
		this.testmap = testmap;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", candidates=" + candidates
				+ ", isCompleted=" + isCompleted + ", testmap=" + testmap + "]";
	}

	

	
 
    // Getters and Setters
}

