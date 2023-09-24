package com.examserver.models.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;
	
	private String title;
	
	 @Column(length = 500)
	private String discrption;
	
	private String  maxMarks;
	
	private String numberOfQuestion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	
	@OneToMany(mappedBy ="quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question>  question =new LinkedHashSet<>();
	
	
	
	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category cotegory) {
		this.category = cotegory;
	}

	private   boolean active=false;

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscrption() {
		return discrption;
	}

	public void setDiscrption(String discrption) {
		this.discrption = discrption;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(String numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
