package integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.AdnApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdnApplication.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.yml" })
@AutoConfigureMockMvc
public class ChairRestControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	@SqlGroup({
			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:import.sql") })

	public void getChairsTest() throws Exception {
		// arrange

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/chairs").contentType(MediaType.APPLICATION_JSON);
		// act
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", equalTo(1))).andExpect(jsonPath("$[1].id", equalTo(2))).andExpect(jsonPath("$[2].id", equalTo(3)));
	}
}
