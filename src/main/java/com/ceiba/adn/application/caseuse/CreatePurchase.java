package com.ceiba.adn.application.caseuse;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.ceiba.adn.application.command.ChairCommand;
import com.ceiba.adn.domain.model.Purchase;

@Service
public class CreatePurchase {

	public Purchase createPurchase(ChairCommand chairCommand) {
		Purchase purchase = new Purchase(chairCommand.getId());

		purchase.validatePurchaseTime(Calendar.HOUR_OF_DAY);
		purchase.validatePurchaseDay(Calendar.DAY_OF_WEEK);

		return purchase;
	}
}
