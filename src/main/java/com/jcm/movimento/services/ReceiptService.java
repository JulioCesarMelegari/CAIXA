package com.jcm.movimento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcm.movimento.entities.ReceiptCoins;
import com.jcm.movimento.repositories.ReceiptCoinsRepository;

@Service
@Transactional
public class ReceiptService {
	
	@Autowired
	ReceiptCoinsRepository repository;
	
	public List<ReceiptCoins> listAll(){
		return repository.findAll();
	}
	
	public void save(ReceiptCoins receiptCoins) {
		repository.save(receiptCoins);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public ReceiptCoins getById(Integer id) {
		return repository.getById(id);
	}
}
