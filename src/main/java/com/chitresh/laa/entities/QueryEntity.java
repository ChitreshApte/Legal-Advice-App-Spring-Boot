package com.chitresh.laa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "query_entity")
public class QueryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long queryId;
	private Long poster;
	private String title;
	private String domain;
	private String posterEmail;
	private String queryDetails;
	private String dateTime;
	
	public QueryEntity() {
		super();
	}

	public QueryEntity(Long poster, String title, String domain, String posterEmail, String queryDetails,
			String dateTime) {
		super();
		this.poster = poster;
		this.title = title;
		this.domain = domain;
		this.posterEmail = posterEmail;
		this.queryDetails = queryDetails;
		this.dateTime = dateTime;
	}

	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	public Long getPoster() {
		return poster;
	}

	public void setPoster(Long poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPosterEmail() {
		return posterEmail;
	}

	public void setPosterEmail(String posterEmail) {
		this.posterEmail = posterEmail;
	}

	public String getQueryDetails() {
		return queryDetails;
	}

	public void setQueryDetails(String queryDetails) {
		this.queryDetails = queryDetails;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
}
