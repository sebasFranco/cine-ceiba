package integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.AdnApplication;
import com.ceiba.adn.domain.model.Chair;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import builder.ChairBuilder;

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

	@Before
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

	@Test
    @Ignore
    public void findAllChairs() throws Exception {
        mockMvc.perform(get("/chairs").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }
	
}
