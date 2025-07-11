package com.jcm.movimento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcm.movimento.entities.MovCash;
import com.jcm.movimento.entities.Status;
import com.jcm.movimento.repositories.MovCashRepository;

@Service
@Transactional
public class MovService {
	
	@Autowired
	private MovCashRepository serviceRepository;
	
	public List<MovCash> listAll(){
		return serviceRepository.findAll();
	}
	
	public List<MovCash> listByStatus(Status status){
		return serviceRepository.findByStatus(status);
	}
	
	public void save(MovCash mov) {
		serviceRepository.save(mov);
	}
	
	public void delete(Integer id) {
		MovCash mov = new MovCash();
		mov = serviceRepository.findById(id).get();
		mov.setStatus(Status.CANCELADO);
	}
	
	@SuppressWarnings("deprecation")
	public MovCash getById(Integer id) {
		return serviceRepository.getById(id);
	}

}
