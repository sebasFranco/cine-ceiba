package com.ceiba.adn.infrastructure.adapter.jpa.jpaentity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chairs")
public class ChairEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private boolean status;

	public Long getId() {
		return id;
	}
}
