package com.ceiba.adn.application.command;

public class ChairCommand {
	private Long id;
	private String name;
	private boolean status;

	public ChairCommand(Long id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

}
