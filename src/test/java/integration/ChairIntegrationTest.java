package integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



import com.ceiba.adn.AdnApplication;
import com.ceiba.adn.domain.model.Chair;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import builder.ChairBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.ParseException;

import javax.transaction.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdnApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
class ChairIntegrationTest {

	public static final Long id = 1L;
	public static final String name = "A1";
	public static final boolean status = true;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	private Chair chair;
	private ObjectWriter objectWriter;

	@BeforeEach
	public void setUp() throws ParseException {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		ChairBuilder chairBuilder = new ChairBuilder().withId(id).withName(name).withStatus(status);

		chair = ChairBuilder.build();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
	}

	@Transactional
	@Rollback(true)
	@Test
//	@SqlGroup({
//			@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:integration/beforesavepeople.sql"),
//			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:integration/aftersavepeople.sql") })

	public void getPersonTest() throws Exception {
		// arrange

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/chairs").contentType(MediaType.APPLICATION_JSON);
		// act
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id", equalTo(1000))).andExpect(jsonPath("$[1].id", equalTo(2000)));
	}
	
}
