package com.examserver.models.exam;


import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Long cid;
	 private String title;
	 private String description;
	 
	 @OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	 @JsonIgnore   // to ignore cyclic dependence
	 private Set<Quiz> quiz=new  LinkedHashSet<>();
	 
	public Category() {
		
	}
	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", title=" + title + ", description=" + description + "]";
	}
	 
	 
}
