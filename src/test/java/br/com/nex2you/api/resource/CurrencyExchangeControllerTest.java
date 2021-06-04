package br.com.nex2you.api.resource;

import static org.junit.Assert.assertTrue;
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

import br.com.nex2you.api.resource.CurrencyExchangeController;
import br.com.nex2you.api.resource.ExchangeValue;
import br.com.nex2you.api.resource.ExchangeValueRepository;
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
        Mockito.when(repository.findByFromAndTo("EUR", "INR")).thenReturn(new ExchangeValue(Long.getLong("1"), "EUR", "INR", BigDecimal.valueOf(80.00)));
        mvc.perform(get("/api/from/EUR/to/INR")).andExpect(status().isOk());
        
        assertTrue(false);
    }
}