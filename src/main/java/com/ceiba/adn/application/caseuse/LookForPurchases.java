package com.ceiba.adn.application.caseuse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

@Service
public class LookForPurchases {

	@Autowired
	private PurchaseRepository iPurchaseRepository;

	public LookForPurchases() {
	}

	public LookForPurchases(PurchaseRepository iPurchaseRepository) {
		super();
		this.iPurchaseRepository = iPurchaseRepository;
	}

	public List<Purchase> getAll() {
		return iPurchaseRepository.findAll();
	}
}
