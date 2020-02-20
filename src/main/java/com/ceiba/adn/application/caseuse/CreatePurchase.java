package com.ceiba.adn.application.caseuse;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.ceiba.adn.application.command.ChairCommand;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

@Service
public class CreatePurchase {

	private PurchaseRepository iPurchaseRepository;

	public CreatePurchase(PurchaseRepository iPurchaseRepository) {
		super();
		this.iPurchaseRepository = iPurchaseRepository;
	}

	public Purchase createPurchase(ChairCommand chairCommand) {
		Purchase purchase = new Purchase();

		purchase.setChair(chairCommand.getId());
		purchase.validatePurchaseTime(Calendar.HOUR_OF_DAY);
		purchase.validatePurchaseDay(Calendar.DAY_OF_WEEK);

		return purchase;
	}
}
