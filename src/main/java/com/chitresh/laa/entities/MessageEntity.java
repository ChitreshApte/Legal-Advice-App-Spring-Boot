package com.chitresh.laa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_entity")
public class MessageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long messageId;
	private String dateTime;
	private Long sender;
	private Long receiver;
	private String message;
	
	public MessageEntity() {
		super();
	}
	
	public MessageEntity(String dateTime, Long sender, Long receiver, String message) {
		super();
		this.dateTime = dateTime;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	
	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Long getSender() {
		return sender;
	}

	public void setSender(Long sender) {
		this.sender = sender;
	}

	public Long getReceiver() {
		return receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
