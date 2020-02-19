package com.ceiba.adn.infrastructure.adapter.jpa.jpaentity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.ceiba.adn.domain.model.Chair;

@Entity
@Table(name = "chairs")
public class ChairEntity extends Chair{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private boolean status;
}
