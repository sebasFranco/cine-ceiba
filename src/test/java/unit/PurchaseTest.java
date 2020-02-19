package unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.domain.Exceptions.InvalidPurchaseTimeException;
import com.ceiba.adn.domain.constant.TicketValue;
import com.ceiba.adn.domain.model.Purchase;

import static builder.PurchaseBuilder.anPurchase;

class PurchaseTest {

	@Test
	void testValidatePurchaseMorningTimeSeven() {

		double finalValue;

		// Arrange
		Purchase purchase = anPurchase().withPurchaseTime(7).build();
		
		// Act
		purchase.validatePurchaseTime(purchase.getPurchaseTime());

		finalValue = purchase.getTotal();

		// Assert
		assertEquals(TicketValue.INITIAL_VALUE * 0.5, finalValue);
	}

	@Test
	void testValidatePurchaseMorningTimeEight() {

		double finalValue;

		// Arrange
		Purchase purchase = anPurchase().withPurchaseTime(8).build();
		
		// Act
		purchase.validatePurchaseTime(purchase.getPurchaseTime());

		finalValue = purchase.getTotal();

		// Assert
		assertEquals(TicketValue.INITIAL_VALUE * 0.5, finalValue);
	}

	@Test
	void testValidatePurchaseMorningTimeNine() {

		double finalValue;

		// Arrange
		Purchase purchase = anPurchase().withPurchaseTime(9).build();
		
		// Act
		purchase.validatePurchaseTime(purchase.getPurchaseTime());

		finalValue = purchase.getTotal();

		// Assert
		assertEquals(TicketValue.INITIAL_VALUE * 0.5, finalValue);
	}

	@Test
	void testValidatePurchaseAfternoonTime() {

		double finalValue;

		// Arrange
		Purchase purchase = anPurchase().withPurchaseTime(16).build();
		
		// Act
		purchase.validatePurchaseTime(purchase.getPurchaseTime());
		finalValue = purchase.getTotal();

		// Assert
		assertEquals(TicketValue.INITIAL_VALUE * 1.5, finalValue);
	}

	@Test
	void testValidatePurchaseNoonTime() {

		double finalValue;

		// Arrange
		Purchase purchase = anPurchase().withPurchaseTime(12).build();
		
		// Act
		purchase.validatePurchaseTime(purchase.getPurchaseTime());
		finalValue = purchase.getTotal();

		// Assert
		assertEquals(TicketValue.INITIAL_VALUE, finalValue);
	}

	@Test
	void testValidatePurchaseWeekEndDay() {

		double finalValue;

		// Arrange
		Purchase purchase = anPurchase().withPurchaseTime(12).withPurchaseDay(6).build();
		
		// Act
		purchase.validatePurchaseDay(purchase.getPurchaseDay());
		finalValue = purchase.getTotal();

		// Assert
		assertEquals(TicketValue.INITIAL_VALUE * 2, finalValue);
	}

	@Test
	void testValidatePurchaseMorningTimeWeekEndDay() {

		double finalValue;

		// Arrange
		Purchase purchase = anPurchase().withPurchaseTime(9).withPurchaseDay(7).build();
		
		// Act
		purchase.validatePurchaseTime(purchase.getPurchaseTime());
		purchase.validatePurchaseDay(purchase.getPurchaseDay());
		finalValue = purchase.getTotal();
		
		// Assert
		assertEquals((TicketValue.INITIAL_VALUE * 0.5) * 2, finalValue);
	}

	@Test
	void testValidatePurchaseAfternoonTimeWeekEndDay() {

		double finalValue;

		// Arrange
		Purchase purchase = anPurchase().withPurchaseTime(17).withPurchaseDay(1).build();
		
		// Act
		purchase.validatePurchaseTime(purchase.getPurchaseTime());
		purchase.validatePurchaseDay(purchase.getPurchaseDay());
		finalValue = purchase.getTotal();

		// Assert
		assertEquals((TicketValue.INITIAL_VALUE * 1.5) * 2, finalValue);
	}
	
	@Test
	void testValidatePurchaseBeforeMovieException() {
		// Arrange
		Purchase purchase = anPurchase().withPurchaseTime(20).build();
		
		try {
			// Act
			purchase.validatePurchaseTime(purchase.getPurchaseTime());
		    fail("Se esperaba excepcion InvalidPurchaseTimeException");
		  }/*Assert*/catch(InvalidPurchaseTimeException e) {}
		
	}
	
	

}
