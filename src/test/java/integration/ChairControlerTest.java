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
import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.ports.ChairRepository;

import builder.ChairBuilder;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AdnApplication.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.yml" })
@AutoConfigureMockMvc
public class ChairControlerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@Autowired
	private ChairRepository chairRepository;
	
	Chair chair;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGetChairs() throws Exception {
		chair = new ChairBuilder().withId(1L).withName("A1").withStatus("Disponible").build();
		chairRepository.save(chair);
		List<Chair> chairs = new ArrayList<>();
		chairs=chairRepository.findAll();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/chairs")
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status()
				.isOk())
				.andExpect(jsonPath("$[0].name", is(chairs.get(0).getName())))
				.andExpect(jsonPath("$[0].status", is(chairs.get(0).getStatus())));
	}
}
