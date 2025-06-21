package com.assignment.lms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.lms.entity.Publisher;
import com.assignment.lms.repository.PublisherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PublisherService {

	@Autowired
	PublisherRepository publisherRepo;

	public Flux<Publisher> getPublishers() {
		return publisherRepo.findAll();
	}

	public Mono<Publisher> savePublisher(Publisher publisher) {
		return publisherRepo.save(publisher);
	}

	public Mono<Publisher> getPublisher(String id) {
		return publisherRepo.findById(id);
	}

}
