package com.hexaware.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feedbackText;
    private double rating;
 
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
 
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(Long id, String feedbackText, double rating, Candidate candidate, Course course) {
		super();
		this.id = id;
		this.feedbackText = feedbackText;
		this.rating = rating;
		this.candidate = candidate;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", feedbackText=" + feedbackText + ", Rating=" + rating
				+ ", candidate=" + candidate + ", course=" + course + "]";
	}
 
    // Getters and setters
}
