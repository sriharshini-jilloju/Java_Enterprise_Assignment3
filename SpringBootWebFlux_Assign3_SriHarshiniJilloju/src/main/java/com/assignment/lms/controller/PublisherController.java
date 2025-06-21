package com.assignment.lms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.lms.entity.Publisher;
import com.assignment.lms.service.PublisherService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PublisherController {

	@Autowired
	PublisherService publisherService;

	@GetMapping("/get-publishers")
	public Flux<Publisher> getPublishers() {
		return publisherService.getPublishers();
	}

	@PostMapping("/save-publisher")
	public Mono<Publisher> savePublisher(@RequestBody Publisher publisher) {
		return publisherService.savePublisher(publisher);
	}

	@GetMapping("/get-publisher")
	public Mono<Publisher> getPublisher(@RequestParam("id") String id) {
		return publisherService.getPublisher(id);
	}

}