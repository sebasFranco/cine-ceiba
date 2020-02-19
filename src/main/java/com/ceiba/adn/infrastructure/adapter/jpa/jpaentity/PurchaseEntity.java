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

	public Long getId() {
		return id;
	}
}
