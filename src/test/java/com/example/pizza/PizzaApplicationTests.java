package com.example.pizza;

import com.example.pizza.controller.IngridientController;
import com.example.pizza.controller.PizzaController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PizzaApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private IngridientController ingridientController;

	@Autowired
	private PizzaController pizzaController;

	@Test
	void contextLoads() {
		assertThat(ingridientController).isNotNull();
		assertThat(pizzaController).isNotNull();
	}

	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/").contentType(MediaType.TEXT_HTML))
				.andDo(print())
				.andExpect(status().is4xxClientError());
	}
}
