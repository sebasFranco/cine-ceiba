package com.ceiba.adn.domain.model;

public class Chair {

	private Long id;
	private String name;
	private boolean status;

	public Chair() {
	}

	public Chair(Long id, String name, boolean status) {
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

	public boolean isStatus() {
		return status;
	}

	public void changeStatus(boolean status) {
		if (status) {
			this.status = false;
		} else {
			this.status = true;
		}
	}

}
