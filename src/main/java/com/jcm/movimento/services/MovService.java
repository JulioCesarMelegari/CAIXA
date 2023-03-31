package com.jcm.movimento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcm.movimento.entities.MovCash;
import com.jcm.movimento.repositories.MovCashRepository;

@Service
@Transactional
public class MovService {
	
	@Autowired
	private MovCashRepository serviceRepository;
	
	public List<MovCash> listAll(){
		return serviceRepository.findAll();
	}
	
	public void save(MovCash mov) {
		serviceRepository.save(mov);
	}
	
	public void delete(Integer id) {
		serviceRepository.deleteById(id);
	}
	
	public MovCash getById(Integer id) {
		return serviceRepository.getById(id);
	}
	
	
	public double SumCoins(MovCash mov) {
		double value1= mov.getReceiptCoins().getCoinFivecents() *.05;
		double value2= mov.getReceiptCoins().getCoinTencents() *0.1;
		double value3= mov.getReceiptCoins().getCoinTwentyfivecents() *.25;
		double value4= mov.getReceiptCoins().getCoinFifitycents() *.5;
		double value5= mov.getReceiptCoins().getCoinOne() *1;
		double total1 = value1+value2+value3+value4+value5;
		return total1;
	}
	
	private double SumBallots(MovCash mov) {
		double value6 = mov.getReceiptCoins().getBallotTwo() *2;
		double value7 = mov.getReceiptCoins().getBallotFive() *5;
		double value8 = mov.getReceiptCoins().getBallotTen() *10;
		double value9 = mov.getReceiptCoins().getBallotTwenty() *20;
		double value10 = mov.getReceiptCoins().getBallotFifity() *50;
		double value11 = mov.getReceiptCoins().getBallotOnehundred() *100;
		double value12 = mov.getReceiptCoins().getBallotTwohundred() *200;
		double total2 = value6+value7+value8+value9+value10+value11+value12;	
		return total2;				
	}
}
