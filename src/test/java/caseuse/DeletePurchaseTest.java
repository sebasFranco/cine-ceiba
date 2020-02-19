package caseuse;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ceiba.adn.application.caseuse.LookForChairs;
import com.ceiba.adn.application.caseuse.DeletePurchase;
import com.ceiba.adn.application.caseuse.LookForPurchases;
import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.domain.ports.PurchaseRepository;

import builder.ChairBuilder;
import builder.PurchaseBuilder;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class DeletePurchaseTest {

	private DeletePurchase deletePurchase;
	
	@Mock
	private PurchaseRepository purchaseRepository;
	
	@Mock
	private ChairRepository chairRepository;
	
	@BeforeEach
	public void setup (){
        MockitoAnnotations.initMocks(this);
        this.deletePurchase = new DeletePurchase(purchaseRepository);
    }
	
	@Test
    public void deleteTest(){
		
    }

}
