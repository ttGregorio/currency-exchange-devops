package br.com.nex2you.api.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.nex2you.api.controller.CurrencyExchangeController;
import br.com.nex2you.api.model.ExchangeValue;
import br.com.nex2you.api.repository.ExchangeValueRepository;
import br.com.nex2you.api.util.environment.InstanceInformationService;

@RunWith(SpringRunner.class)
@WebMvcTest(CurrencyExchangeController.class)
public class CurrencyExchangeControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private ExchangeValueRepository repository;

	@MockBean
	private InstanceInformationService instanceInformationService;

	@Test
	public void imHealthy() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void retrieveExchangeValue() throws Exception {
		Mockito.when(repository.findByFromAndTo("EUR", "INR")).thenReturn(ExchangeValue.builder().from("EUR").to("INR")
				.id(1L).conversionMultiple(BigDecimal.valueOf(80.00)).build());
		mvc.perform(get("/api/from/EUR/to/INR")).andExpect(status().isOk());
	}
}