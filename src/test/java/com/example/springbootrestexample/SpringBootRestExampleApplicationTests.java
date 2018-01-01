package com.example.springbootrestexample;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(GreetingController.class)
public class SpringBootRestExampleApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private GreetingController greetingController;

	@Test
	public void testGreeting() throws Exception {
		/*mockMvc.perform(get("/greeting?name=Patrícia Espada"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("content", is("Hello Patrícia Espada!")));*/
		MvcResult result = mockMvc.perform(get("/greeting?name=Patrícia Espada")).andReturn();

		System.out.println(result.getResponse());
		String expected = "{content:Hello Patrícia Espada!}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
