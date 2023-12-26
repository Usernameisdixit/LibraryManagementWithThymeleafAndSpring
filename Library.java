package com.csm.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

import javax.persistence.*;
import java.util.List;

@Entity
public class Library {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String subscriptionType;
    private double subscriptionfee;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "library_id")
    private List<Applicant> applicant;
    
	

	public List<Applicant> getApplicant() {
		return applicant;
	}

	public void setApplicant(List<Applicant> applicant) {
		this.applicant = applicant;
	}

	public Long getId() {
		return id;
	}
	
	public Library()
	{
		
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
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public double getFee() {
		return subscriptionfee;
	}
	public void setFee(double fee) {
		this.subscriptionfee = fee;
	}
	
}
