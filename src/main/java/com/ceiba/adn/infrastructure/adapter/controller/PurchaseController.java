package com.ceiba.adn.infrastructure.adapter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.application.caseuse.DeletePurchase;
import com.ceiba.adn.application.caseuse.LookForPurchases;
import com.ceiba.adn.application.caseuse.CreatePurchase;
import com.ceiba.adn.application.caseuse.SavePurchase;
import com.ceiba.adn.application.command.PurchaseCommand;
import com.ceiba.adn.application.command.ChairCommand;
import com.ceiba.adn.domain.model.Purchase;

@RestController
@RequestMapping("/Purchase")
public class PurchaseController {

	private CreatePurchase purchaseService;
	private DeletePurchase deleteService;
	private LookForPurchases lookForPurchaseService;
	private SavePurchase savePurchaseService;

	public PurchaseController(CreatePurchase compraService, DeletePurchase borrarService, LookForPurchases buscarComprasService) {
		this.purchaseService = compraService;
		this.deleteService = borrarService;
		this.lookForPurchaseService = buscarComprasService;
	}

	@PostMapping
	public Purchase createPurchase(@RequestParam ChairCommand chairCommand) {
		return purchaseService.createPurchase(chairCommand);
	}
	
	@PutMapping
	public Purchase savePurchase(@RequestBody PurchaseCommand purchaseCommand) {
		return savePurchaseService.savePurchase(purchaseCommand);
	}
	
	@GetMapping()
	public List<Purchase> getAll() {
		return lookForPurchaseService.getAll();
	}

	@DeleteMapping("{id}")
	public String delete(@RequestParam PurchaseCommand purchaseCommand) {
		deleteService.deletePurchase(purchaseCommand);
		return "redirect:/purchase";
	}
}
