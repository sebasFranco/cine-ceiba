package builder;

import com.ceiba.adn.domain.model.Chair;

public class ChairBuilder {

	private static Long id;
	private static String name;
	private static String status;

	public ChairBuilder() {
		this.id = 1L;
		this.name = "A1";
		this.status = "Disponible";
	}

	public ChairBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public ChairBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public ChairBuilder withStatus(String status) {
		this.status = status;
		return this;
	}
	public Chair build() {
		return new Chair(id, name, status);
	}
	
	public static ChairBuilder anChair(){
        return new ChairBuilder();
    }
	
}
