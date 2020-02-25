package com.ceiba.adn.infrastructure.adapter.jpa.jpaentity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchases")
public class PurchaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Long chair;

	@NotNull
	@Column(name = "id_client")
	private Long idClient;

	@NotNull
	@Column(name = "purchase_time")
	private int purchaseTime;

	@NotNull
	@Column(name = "purchase_day")
	private int purchaseDay;

	@NotNull
	private double total;

	public PurchaseEntity() {
	}

	public PurchaseEntity(Long id, @NotNull Long chair, @NotNull Long idClient, @NotNull int purchaseTime,
			@NotNull int purchaseDay, @NotNull double total) {
		super();
		this.id = id;
		this.chair = chair;
		this.idClient = idClient;
		this.purchaseTime = purchaseTime;
		this.purchaseDay = purchaseDay;
		this.total = total;
	}

	public Long getChair() {
		return chair;
	}

	public Long getId() {
		return id;
	}

	public int getPurchaseTime() {
		return purchaseTime;
	}

	public Long getIdClient() {
		return idClient;
	}

	public double getTotal() {
		return total;
	}

	public int getPurchaseDay() {
		return purchaseDay;
	}

}
