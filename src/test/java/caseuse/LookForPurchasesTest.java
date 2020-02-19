package caseuse;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ceiba.adn.application.caseuse.LookForPurchases;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

import builder.PurchaseBuilder;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

class LookForPurchasesTest {

	private LookForPurchases lookForPurchases;
	
	@Mock
	private PurchaseRepository purchaseRepository;
	
	@BeforeEach
	public void setup (){
        MockitoAnnotations.initMocks(this);
        this.lookForPurchases = new LookForPurchases(purchaseRepository);
    }
	
	@Test
    public void findAllTest(){
        //arrange
        List<Purchase> purchases = new ArrayList<Purchase>();
        
        purchases.add(new PurchaseBuilder().withId(1L).withChair(1L).withIdClient(123456L).withPurchaseTime(12).withPurchaseDay(3).withTotal(15000).build());
        purchases.add(new PurchaseBuilder().withId(2L).withChair(2L).withIdClient(654321L).withPurchaseTime(12).withPurchaseDay(3).withTotal(15000).build());
		        
        when(this.purchaseRepository.findAll()).thenReturn(purchases);
        //act
        List<Purchase> purchasesResponse = this.lookForPurchases.getAll();
        //assert
        
        Assertions.assertEquals(purchases.size(), purchasesResponse.size());
        Assertions.assertEquals(123456L, purchasesResponse.get(0).getIdClient());
        Assertions.assertEquals(654321L, purchasesResponse.get(1).getIdClient());
    }
}
