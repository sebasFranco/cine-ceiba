package com.ceiba.adn.application.caseuse;

import org.springframework.stereotype.Service;

import com.ceiba.adn.application.command.PurchaseCommand;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

@Service
public class DeletePurchase {

	private PurchaseRepository purchaseRepository;

	public DeletePurchase(PurchaseRepository purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
	}

	public void deletePurchase(PurchaseCommand purchaseCommand) {
		purchaseRepository.deletePurchase(new Purchase(purchaseCommand.getId(), purchaseCommand.getChair(),
				purchaseCommand.getIdClient(), purchaseCommand.getPurchaseTime(), purchaseCommand.getPurchaseDay(),
				purchaseCommand.getTotal()));
	}

}
