package com.sanitas.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@WebMvcTest
class CalculatorApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Value("${calculator.presentation.path.base}")
	private String basePath;

	@Value("${calculator.presentation.path.operation}")
	private String operationPath;

	@Test
	void operationAddValid() {

//		mvc.perform(get())
	}

}
