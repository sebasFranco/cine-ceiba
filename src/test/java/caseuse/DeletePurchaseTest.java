package caseuse;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ceiba.adn.application.caseuse.LookForChairs;
import com.ceiba.adn.application.caseuse.DeletePurchase;
import com.ceiba.adn.application.caseuse.LookForPurchases;
import com.ceiba.adn.application.command.PurchaseCommand;
import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.domain.ports.PurchaseRepository;

import builder.ChairBuilder;
import builder.PurchaseBuilder;
import builder.PurchaseCommandBuilder;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class DeletePurchaseTest {

	private DeletePurchase deletePurchase;
	
	@Mock
	private PurchaseRepository purchaseRepository;
	
	@BeforeEach
	public void setup (){
        MockitoAnnotations.initMocks(this);
        this.deletePurchase = new DeletePurchase(purchaseRepository);
    }
	
	@Test
    public void deleteTest(){
		// arrange
		Purchase purchase = new PurchaseBuilder().withId(1L).withChair(1L).withIdClient(123456L).build();

		PurchaseCommand purchaseCommand = new PurchaseCommandBuilder().withId(1L).withChair(1L).withIdClient(123456L)
				.build();
		doNothing().when(this.purchaseRepository).deletePurchase(purchase);

		// act
		Purchase purchaseResponse = this.deletePurchase.deletePurchase(purchaseCommand);
		
		// assert
		Assertions.assertEquals(purchaseCommand.getIdClient(), purchaseResponse.getIdClient());
    }

}
