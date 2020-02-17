package com.ceiba.adn.infrastructure.adapter.jpa.jpaentity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "purchases")
public class PurchaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Long chair;

	@NotNull
	private Long idClient;

	@NotNull
	private int purchaseTime;

	@NotNull
	private int purchaseDay;

	@NotNull
	private double total;

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

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
