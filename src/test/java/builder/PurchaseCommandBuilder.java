package builder;

import com.ceiba.adn.application.command.PurchaseCommand;
import com.ceiba.adn.domain.model.Purchase;

public class PurchaseCommandBuilder {

	private Long id;
	private Long chair;
	private Long idClient;
	private int purchaseTime;
	private int purchaseDay;
	private double total;

	public PurchaseCommandBuilder() {
		this.id = 1L;
		this.chair = 1L;
		this.idClient = 12345L;
		this.purchaseTime = 12;
		this.purchaseDay = 3;
		this.total = 15000;
	}

	public PurchaseCommandBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public PurchaseCommandBuilder withChair(Long chair) {
		this.chair = chair;
		return this;
	}

	public PurchaseCommandBuilder withIdClient(Long idClient) {
		this.idClient = idClient;
		return this;
	}

	public PurchaseCommandBuilder withPurchaseTime(int purchaseTime) {
		this.purchaseTime = purchaseTime;
		return this;
	}
	
	public PurchaseCommandBuilder withPurchaseDay(int purchaseDay) {
		this.purchaseDay = purchaseDay;
		return this;
	}
	
	public PurchaseCommandBuilder withTotal(double total) {
		this.total = total;
		return this;
	}
	
	public PurchaseCommand build() {
		return new PurchaseCommand(id, chair, idClient, purchaseTime, purchaseDay, total);
	}
	
	public static PurchaseCommandBuilder anPurchase(){
        return new PurchaseCommandBuilder();
    }
	
}
