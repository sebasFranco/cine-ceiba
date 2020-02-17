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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getChair() {
		return chair;
	}

	public void setChair(Long chair) {
		this.chair = chair;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public int getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(int purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public int getPurchaseDay() {
		return purchaseDay;
	}

	public void setPurchaseDay(int purchaseDay) {
		this.purchaseDay = purchaseDay;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
