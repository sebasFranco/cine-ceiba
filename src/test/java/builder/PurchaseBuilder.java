package builder;

import com.ceiba.adn.domain.model.Purchase;

public class PurchaseBuilder {

	private Long id;
	private Long chair;
	private Long idClient;
	private int purchaseTime;
	private int purchaseDay;
	private double total;

	public PurchaseBuilder() {
		this.id = 1L;
		this.chair = 1L;
		this.idClient = 12345L;
		this.purchaseTime = 12;
		this.purchaseDay = 3;
		this.total = 15000;
	}

	public PurchaseBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public PurchaseBuilder withChair(Long chair) {
		this.chair = chair;
		return this;
	}

	public PurchaseBuilder withIdClient(Long idClient) {
		this.idClient = idClient;
		return this;
	}

	public PurchaseBuilder withPurchaseTime(int purchaseTime) {
		this.purchaseTime = purchaseTime;
		return this;
	}
	
	public PurchaseBuilder withPurchaseDay(int purchaseDay) {
		this.purchaseDay = purchaseDay;
		return this;
	}
	
	public PurchaseBuilder withTotal(double total) {
		this.total = total;
		return this;
	}
	
	public Purchase build() {
		return new Purchase(id, chair, idClient, purchaseTime, purchaseDay, total);
	}
	
	public static PurchaseBuilder anPurchase(){
        return new PurchaseBuilder();
    }
	
}
