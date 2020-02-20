package unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.domain.model.Chair;

import static builder.ChairBuilder.anChair;

class ChairTest {

	@Test
	void testChangeStatusTrue() {

		// Arrange
		Chair chair = anChair().withStatus(true).build();

		// Act
		chair.changeStatus(chair.isStatus());

		// Assert
		assertEquals(false, chair.isStatus());
	}
	
	@Test
	void testChangeStatusFalse() {

		// Arrange
		Chair chair = anChair().withStatus(false).build();

		// Act
		chair.changeStatus(chair.isStatus());

		// Assert
		assertEquals(true, chair.isStatus());
	}
}
