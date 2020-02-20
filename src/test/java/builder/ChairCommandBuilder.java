package builder;

import com.ceiba.adn.application.command.ChairCommand;

public class ChairCommandBuilder {

	private static Long id;
	private static String name;
	private static boolean status;

	public ChairCommandBuilder() {
		this.id = 1L;
		this.name = "A1";
		this.status = true;
	}

	public ChairCommandBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public ChairCommandBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public ChairCommandBuilder withStatus(boolean status) {
		this.status = status;
		return this;
	}
	public ChairCommand build() {
		return new ChairCommand(id, name, status);
	}
	
	public static ChairCommandBuilder anPurchase(){
        return new ChairCommandBuilder();
    }
	
}
