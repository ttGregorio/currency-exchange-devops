package br.com.nex2you.api.cucumber;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import br.com.nex2you.api.CurrencyExchangeServiceApplication;
import cucumber.api.java.Before;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = CurrencyExchangeServiceApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {

  @Before
  public void setUp() {
  }
}