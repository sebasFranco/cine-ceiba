package com.ceiba.adn.domain.model;

public class Chair {

	private Long id;
	private String name;
	private boolean status;

	public Chair(Long id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
