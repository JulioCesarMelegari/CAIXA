package com.jcm.movimento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcm.movimento.entities.MovCash;
import com.jcm.movimento.entities.Payment;

public interface PaymentsRepository extends JpaRepository<Payment, Integer>{
	
	List<Payment> findByMovCash(MovCash movCash);

}
