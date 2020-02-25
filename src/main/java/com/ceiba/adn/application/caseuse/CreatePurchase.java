package com.ceiba.adn.application.caseuse;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.ceiba.adn.application.command.ChairCommand;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

@Service
public class CreatePurchase {

	PurchaseRepository purchaseRepository;
	
	public CreatePurchase(PurchaseRepository purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
	}

	public Purchase createPurchase(ChairCommand chairCommand) {
		Purchase purchase = new Purchase(chairCommand.getId());

		purchase.validatePurchaseTime(Calendar.HOUR_OF_DAY);
		purchase.validatePurchaseDay(Calendar.DAY_OF_WEEK);

		return purchase;
	}
}
