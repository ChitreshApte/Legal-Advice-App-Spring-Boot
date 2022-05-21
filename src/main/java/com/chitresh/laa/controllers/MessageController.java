package com.chitresh.laa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitresh.laa.entities.MessageEntity;
import com.chitresh.laa.payload.response.MessageResponse;
import com.chitresh.laa.repository.MessageRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/messages/")
public class MessageController {
	
	@Autowired
	MessageRepository msgRepo;
	
	//adding a new message
	@PostMapping
	public ResponseEntity<?> addNewMessage(@RequestBody MessageEntity msg) {
		msgRepo.save(msg);
		return ResponseEntity.ok(new MessageResponse("Message delivered successfully!"));
	}
	
	//this is only mapping, returns all the messages in which I am the sender or I am the receiver
	//TODO better do this with SQL query later, it will be much faster I guess
	@GetMapping("{id}")
	public List<MessageEntity> getMyMessages(@PathVariable("id") String pv) {
		Long id = Long.parseLong(pv);
		List<MessageEntity> allMessages = msgRepo.findAll();	
		List<MessageEntity> result = new ArrayList<>();
		for(MessageEntity m : allMessages)
			if(m.getSender() == id || m.getReceiver() == id)
					result.add(m);
		return result;
	}
	
	@GetMapping
	public List<MessageEntity> getAllMessages() {
		return msgRepo.findAll();
	}
}
