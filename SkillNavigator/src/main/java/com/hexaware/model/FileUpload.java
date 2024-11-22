package com.hexaware.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class FileUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileType;
    private String filePath;
 
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

	public FileUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileUpload(Long id, String fileType, String filePath, Candidate candidate) {
		super();
		this.id = id;
		this.fileType = fileType;
		this.filePath = filePath;
		this.candidate = candidate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "FileUpload [id=" + id + ", fileType=" + fileType + ", filePath=" + filePath + ", candidate=" + candidate
				+ "]";
	}
 
    // Getters and setters
}
