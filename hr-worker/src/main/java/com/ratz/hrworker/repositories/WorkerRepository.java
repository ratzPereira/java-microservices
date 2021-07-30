package com.ratz.hrworker.repositories;

import com.ratz.hrworker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;



public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
