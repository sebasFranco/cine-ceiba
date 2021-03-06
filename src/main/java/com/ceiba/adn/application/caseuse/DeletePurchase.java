package com.ceiba.adn.application.caseuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.adn.application.command.PurchaseCommand;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

@Service
public class DeletePurchase {

	@Autowired
	private PurchaseRepository purchaseRepository;

	public DeletePurchase() {
	}

	public DeletePurchase(PurchaseRepository purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
	}

	public Purchase deletePurchase(PurchaseCommand purchaseCommand) {
		Purchase purchase = new Purchase(purchaseCommand.getId(), purchaseCommand.getChair(),
				purchaseCommand.getIdClient(), purchaseCommand.getPurchaseTime(), purchaseCommand.getPurchaseDay(),
				purchaseCommand.getTotal());
		purchaseRepository.deletePurchase(purchase);
		return purchase;
	}

}
