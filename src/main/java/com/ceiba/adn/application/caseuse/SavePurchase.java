package com.ceiba.adn.application.caseuse;

import org.springframework.stereotype.Service;

import com.ceiba.adn.application.command.PurchaseCommand;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

@Service
public class SavePurchase {

	private PurchaseRepository purchaseRepository;

	public SavePurchase(PurchaseRepository purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
	}

	public Purchase savePurchase(PurchaseCommand purchaseCommand) {
		return purchaseRepository.save(new Purchase(purchaseCommand.getId(), purchaseCommand.getChair(),
				purchaseCommand.getIdClient(), purchaseCommand.getPurchaseTime(), purchaseCommand.getPurchaseDay(),
				purchaseCommand.getTotal()));
	}
}
