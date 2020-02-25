package com.ceiba.adn.infrastructure.adapter.jpa.jpaentity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author juan.franco
 *
 */
@Entity
@Table(name = "chairs")
public class ChairEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String status;

	public ChairEntity() {
	}

	public ChairEntity(Long id, @NotNull String name, @NotNull String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public Long getId() {
		return id;
	}

}
