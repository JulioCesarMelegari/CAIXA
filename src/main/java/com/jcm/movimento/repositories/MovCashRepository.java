package com.jcm.movimento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcm.movimento.entities.MovCash;
import com.jcm.movimento.entities.Status;

public interface MovCashRepository extends JpaRepository<MovCash, Integer>{
	
	List<MovCash> findByStatus(Status status);

}
