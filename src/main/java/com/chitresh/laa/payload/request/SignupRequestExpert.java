package com.chitresh.laa.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequestExpert {
	@NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String phoneNumber;
	private String profession;
	private String description;
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
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
