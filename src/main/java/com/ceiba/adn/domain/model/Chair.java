package com.ceiba.adn.domain.model;

public class Chair {

	private Long id;
	private String name;
	private String status;

	public Chair(Long id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public void changeStatus(String status) {
		if ("Disponible".equals(status)) {
			this.status = "Ocupado";
		} else {
			this.status = "Disponible";
		}
	}

}
