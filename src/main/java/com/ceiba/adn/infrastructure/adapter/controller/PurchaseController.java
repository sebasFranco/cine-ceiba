package com.ceiba.adn.infrastructure.adapter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.application.caseuse.DeletePurchase;
import com.ceiba.adn.application.caseuse.LookForPurchases;
import com.ceiba.adn.application.caseuse.CreatePurchase;
import com.ceiba.adn.application.caseuse.SavePurchase;
import com.ceiba.adn.application.command.PurchaseCommand;
import com.ceiba.adn.application.command.ChairCommand;
import com.ceiba.adn.domain.model.Purchase;

import net.bytebuddy.asm.Advice.Return;


@RestController
@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH})
@RequestMapping("/Purchase")
public class PurchaseController {

	@Autowired
	private CreatePurchase purchaseService;
	@Autowired
	private DeletePurchase deleteService;
	@Autowired
	private LookForPurchases lookForPurchaseService;
	@Autowired
	private SavePurchase savePurchaseService;

	public PurchaseController(CreatePurchase compraService, DeletePurchase borrarService, LookForPurchases buscarComprasService) {
		this.purchaseService = compraService;
		this.deleteService = borrarService;
		this.lookForPurchaseService = buscarComprasService;
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Purchase createPurchase(@RequestBody ChairCommand chairCommand) {
		return purchaseService.createPurchase(chairCommand);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Purchase savePurchase(@RequestBody PurchaseCommand purchaseCommand) {
		return savePurchaseService.savePurchase(purchaseCommand);
	}
	
	@GetMapping()
	public List<Purchase> getAll() {
		return lookForPurchaseService.getAll();
	}

	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
	public String delete(@RequestBody PurchaseCommand purchaseCommand) {
		deleteService.deletePurchase(purchaseCommand);
		return "redirect:/Purchase";
	}
}
