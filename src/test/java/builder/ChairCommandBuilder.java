package builder;

import com.ceiba.adn.application.command.ChairCommand;

public class ChairCommandBuilder {

	private static Long id;

	public ChairCommandBuilder() {
		this.id = 1L;
	}

	public ChairCommandBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public ChairCommand build() {
		return new ChairCommand(id);
	}

	public static ChairCommandBuilder anPurchase() {
		return new ChairCommandBuilder();
	}

}
