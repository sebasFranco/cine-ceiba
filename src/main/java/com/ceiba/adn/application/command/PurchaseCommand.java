package com.ceiba.adn.application.command;

public class PurchaseCommand {

	private Long id;
	private Long chair;
	private Long idClient;
	private int purchaseTime;
	private int purchaseDay;
	private double total;

	public PurchaseCommand() {
	}

	public PurchaseCommand(Long id, Long chair, Long idClient, int purchaseTime, int purchaseDay, double total) {
		super();
		this.id = id;
		this.chair = chair;
		this.idClient = idClient;
		this.purchaseTime = purchaseTime;
		this.purchaseDay = purchaseDay;
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public int getPurchaseTime() {
		return purchaseTime;
	}

	public Long getChair() {
		return chair;
	}

	public Long getIdClient() {
		return idClient;
	}

	public Long getId() {
		return id;
	}

	public int getPurchaseDay() {
		return purchaseDay;
	}

}
