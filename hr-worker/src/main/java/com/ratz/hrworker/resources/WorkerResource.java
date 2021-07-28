package com.ratz.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratz.hrworker.entity.Worker;
import com.ratz.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private org.springframework.core.env.Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
				
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findWorkerById(@PathVariable Long id) {
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		
		Worker worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
				
	}
}
