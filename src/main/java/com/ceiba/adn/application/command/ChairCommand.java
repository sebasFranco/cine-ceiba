package com.ceiba.adn.application.command;

public class ChairCommand {
	private Long id;
	private String name;
	private String status;

	public ChairCommand() {
	}

	public ChairCommand(Long id, String name, String status) {
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

	public String isStatus() {
		return status;
	}

}
