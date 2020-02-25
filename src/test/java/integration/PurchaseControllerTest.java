package integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.AdnApplication;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import builder.PurchaseBuilder;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AdnApplication.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.yml" })
@AutoConfigureMockMvc
public class PurchaseControllerTest {

	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	Purchase purchase;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void savePurchaseTest() throws Exception {
		purchase = new PurchaseBuilder().withId(10L).withChair(1L).withIdClient(123456L).withPurchaseTime(12).withPurchaseDay(3).withTotal(15000).build();
		purchaseRepository.save(purchase);
		ObjectMapper objMap = new ObjectMapper();
		ObjectWriter objectWriter = objMap.writer().withDefaultPrettyPrinter();
		mockMvc.perform(post("/Purchase")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectWriter.writeValueAsString(purchase)))
			.andExpect(status().isCreated());
	}
	

	@Transactional
	@Rollback(true)
	@Test
	public void testGetPurchases() throws Exception {
		List<Purchase> purchases = new ArrayList<>();
		purchases=purchaseRepository.findAll();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Purchase")
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status()
				.isOk())
				.andExpect(jsonPath("$[0].chair", is(purchases.get(0).getChair().intValue())))
				.andExpect(jsonPath("$[0].idClient", is(purchases.get(0).getIdClient().intValue())));
	}
}
