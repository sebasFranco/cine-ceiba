package com.ceiba.adn.application.caseuse;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

@Service
public class LookForPurchases {
	
	private PurchaseRepository iPurchaseRepository;
	
	public List<Purchase> getAll(){
		return iPurchaseRepository.findAll();
	}
}
