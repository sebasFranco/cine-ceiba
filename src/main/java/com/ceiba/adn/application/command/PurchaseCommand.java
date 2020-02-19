package com.ceiba.adn.application.command;

public class PurchaseCommand {

	private Long id;
	private Long chair;
	private Long idClient;
	private int purchaseTime;
	private int purchaseDay;
	private double total;

	public PurchaseCommand() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Long getChair() {
		return chair;
	}

	public Long getIdClient() {
		return idClient;
	}

	public int getPurchaseTime() {
		return purchaseTime;
	}

	public int getPurchaseDay() {
		return purchaseDay;
	}

	public double getTotal() {
		return total;
	}
}
