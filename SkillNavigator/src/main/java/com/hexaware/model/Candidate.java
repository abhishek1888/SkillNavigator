package com.hexaware.model;

import java.util.List;

import com.hexaware.model.Batch;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<String> education;
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Feedback> feedbacks;
 
    
    @OneToMany(mappedBy = "candidate")
    private List<FileUpload> fileUploads;
 
    
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(Long id, String name, String email, String phone, List<String> education, List<Feedback> feedbacks,
			List<FileUpload> fileUploads, Batch batch) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.education = education;
		this.feedbacks = feedbacks;
		this.fileUploads = fileUploads;
		this.batch = batch;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getEducation() {
		return education;
	}

	public void setEducation(List<String> education) {
		this.education = education;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<FileUpload> getFileUploads() {
		return fileUploads;
	}

	public void setFileUploads(List<FileUpload> fileUploads) {
		this.fileUploads = fileUploads;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", education="
				+ education + ", feedbacks=" + feedbacks + ", fileUploads=" + fileUploads + ", batch=" + batch + "]";
	}

	
 
    // Getters and setters
    
}

