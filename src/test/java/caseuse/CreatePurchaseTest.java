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
import com.ceiba.adn.application.command.ChairCommand;
import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.domain.ports.PurchaseRepository;

import builder.ChairCommandBuilder;
import builder.PurchaseBuilder;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CreatePurchaseTest {

	private CreatePurchase createPurchase;
	
	@Mock
	private PurchaseRepository purchaseRepository;
	
	@BeforeEach
	public void setup (){
        MockitoAnnotations.initMocks(this);
        this.createPurchase = new CreatePurchase(purchaseRepository);
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
