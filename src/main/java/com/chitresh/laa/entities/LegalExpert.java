package com.chitresh.laa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "legal_experts")
public class LegalExpert {
	@Id
	private Long id;
	private String username;
	private String profession;
	@NotBlank
	private String domainSpecialization;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String country;
	@Size(min = 60)
	private String experience;
	@Size(min = 60)
	private String clientProblems;
	@Size(min = 60)
	private String targetClients;
	@NotBlank
	private String tagline;
	//this will be a comma separated list of keywords that the expert has given while registering
	@NotBlank
	private String keywords;
	
	public LegalExpert() {
		super();
	}

	public LegalExpert(Long id, String username, String profession, String domainSpecialization, String city, String state, String country,
			String experience, String clientProblems, String targetClients, String tagline, String keywords) {
		super();
		this.id = id;
		this.username = username;
		this.profession = profession;
		this.domainSpecialization = domainSpecialization;
		this.city = city;
		this.state = state;
		this.country = country;
		this.experience = experience;
		this.clientProblems = clientProblems;
		this.targetClients = targetClients;
		this.tagline = tagline;
		this.keywords = keywords;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getDomainSpecialization() {
		return domainSpecialization;
	}
	public void setDomainSpecialization(String domainSpecialization) {
		this.domainSpecialization = domainSpecialization;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getClientProblems() {
		return clientProblems;
	}
	public void setClientProblems(String clientProblems) {
		this.clientProblems = clientProblems;
	}
	public String getTargetClients() {
		return targetClients;
	}
	public void setTargetClients(String targetClients) {
		this.targetClients = targetClients;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
}
