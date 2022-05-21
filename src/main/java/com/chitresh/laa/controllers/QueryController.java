package com.chitresh.laa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chitresh.laa.entities.QueryEntity;
import com.chitresh.laa.payload.response.QueryResponse;
import com.chitresh.laa.repository.QueryRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/query/")
public class QueryController {
	
	@Autowired
	QueryRepository queryRepo;

	//adding a new message
	@PostMapping
	public ResponseEntity<?> addNewQuery(@RequestBody QueryEntity query) {
		queryRepo.save(query);
		return ResponseEntity.ok(new QueryResponse("Query posted successfully!"));
	}
	
	@GetMapping
	public List<QueryEntity> getAllQueries() {
		return queryRepo.findAll();
	}
}
