package com.ceiba.adn.domain.ports;

import java.util.List;

import com.ceiba.adn.domain.model.Purchase;

public interface PurchaseRepository {
	
	List<Purchase> findAll();
	
	void save(Purchase purchase);
	
	void deletePurchase(Purchase purchase);
	
}
