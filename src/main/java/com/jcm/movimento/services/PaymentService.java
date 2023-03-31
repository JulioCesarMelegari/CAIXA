package com.jcm.movimento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcm.movimento.entities.Payment;
import com.jcm.movimento.repositories.PaymentsRepository;

@Service
@Transactional
public class PaymentService {
	
	@Autowired
	private PaymentsRepository paymentRepository;
	
	public List<Payment> listAll(){
		return paymentRepository.findAll();
	}
	
	public void save(Payment payments) {
		paymentRepository.save(payments);
	}
	
	public void delete(Integer id) {
		paymentRepository.deleteById(id);
	}
	
	public Payment getById(Integer id) {
		return paymentRepository.getById(id);
	}
}
