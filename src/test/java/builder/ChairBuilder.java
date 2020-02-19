package builder;

import com.ceiba.adn.domain.model.Chair;

public class ChairBuilder {

	private static Long id;
	private static String name;
	private static boolean status;

	public ChairBuilder() {
		this.id = 1L;
		this.name = "A1";
		this.status = true;
	}

	public ChairBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public ChairBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public ChairBuilder withStatus(boolean status) {
		this.status = status;
		return this;
	}
	public Chair build() {
		return new Chair(id, name, status);
	}
	
	public static ChairBuilder anPurchase(){
        return new ChairBuilder();
    }
	
}
