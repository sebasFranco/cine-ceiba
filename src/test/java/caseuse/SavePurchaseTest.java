package caseuse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ceiba.adn.application.caseuse.LookForChairs;
import com.ceiba.adn.application.caseuse.CreatePurchase;
import com.ceiba.adn.application.caseuse.DeletePurchase;
import com.ceiba.adn.application.caseuse.LookForPurchases;
import com.ceiba.adn.application.caseuse.SavePurchase;
import com.ceiba.adn.application.command.ChairCommand;
import com.ceiba.adn.application.command.PurchaseCommand;
import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.domain.ports.PurchaseRepository;

import builder.ChairCommandBuilder;
import builder.PurchaseBuilder;
import builder.PurchaseCommandBuilder;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class SavePurchaseTest {

	private SavePurchase savePurchase;

	@Mock
	private PurchaseRepository purchaseRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.savePurchase = new SavePurchase(purchaseRepository);
	}

	@Test
	public void saveTest() {
		// arrange
		Purchase purchase = new PurchaseBuilder().withId(1L).withChair(1L).withIdClient(123456L).build();

		PurchaseCommand purchaseCommand = new PurchaseCommandBuilder().withId(1L).withChair(1L).withIdClient(123456L)
				.build();
		doNothing().when(this.purchaseRepository).save(purchase);

		// act
		Purchase purchaseResponse = this.savePurchase.savePurchase(purchaseCommand);

		// assert

		Assertions.assertEquals(purchaseCommand.getIdClient(), purchaseResponse.getIdClient());
		}

}
