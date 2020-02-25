package caseuse;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ceiba.adn.application.caseuse.CreatePurchase;
import com.ceiba.adn.application.command.ChairCommand;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

import builder.ChairCommandBuilder;
import builder.PurchaseBuilder;


class CreatePurchaseTest {

	private CreatePurchase createPurchase;
	
	@Mock
	private PurchaseRepository purchaseRepository;
	
	@BeforeEach
	public void setup (){
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void createTest(){
		//arrange
        ChairCommand chairCommand = new ChairCommandBuilder().withId(1L).build();
        Purchase purchase = new PurchaseBuilder().withChair(1L).build();
        
        //act
        Purchase purchaseResponse = this.createPurchase.createPurchase(chairCommand);
        
        //assert
        Assertions.assertEquals(chairCommand.getId(), purchaseResponse.getChair());
        Assertions.assertEquals(purchase.getChair(), purchaseResponse.getChair());
    }

}
