package com.jcm.movimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcm.movimento.entities.Payment;

public interface PaymentsRepository extends JpaRepository<Payment, Integer>{

}
