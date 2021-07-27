package com.ratz.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratz.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
