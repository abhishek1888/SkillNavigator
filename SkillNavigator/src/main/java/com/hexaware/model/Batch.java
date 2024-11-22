package com.hexaware.model;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
 
    @JsonIgnore
    @OneToMany(mappedBy = "batch")
    private List<Candidate> candidates;

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(Long id, String name, Date startDate, Date endDate, List<Candidate> candidates) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.candidates = candidates;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", candidates=" + candidates + "]";
	}
 
    // Getters and setters
}
