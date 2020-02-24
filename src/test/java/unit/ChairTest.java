package unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.domain.model.Chair;

import static builder.ChairBuilder.anChair;

class ChairTest {

	@Test
	void testChangeStatusTrue() {

		// Arrange
		Chair chair = anChair().withStatus("Disponible").build();

		// Act
		chair.changeStatus(chair.getStatus());

		// Assert
		assertEquals("Ocupado", chair.getStatus());
	}
	
	@Test
	void testChangeStatusFalse() {

		// Arrange
		Chair chair = anChair().withStatus("Ocupado").build();

		// Act
		chair.changeStatus(chair.getStatus());

		// Assert
		assertEquals("Disponible", chair.getStatus());
	}
}
