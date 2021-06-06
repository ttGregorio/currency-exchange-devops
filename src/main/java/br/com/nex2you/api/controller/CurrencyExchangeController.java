package br.com.nex2you.api.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.nex2you.api.model.ExchangeValue;
import br.com.nex2you.api.repository.ExchangeValueRepository;
import br.com.nex2you.api.util.environment.InstanceInformationService;

@RestController
public class CurrencyExchangeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private ExchangeValueRepository repository;

	@Autowired
	private InstanceInformationService instanceInformationService;

	@GetMapping("/")
	public String imHealthy() {
		return "{healthy:true}";
	}

	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to,
			@RequestHeader Map<String, String> headers) {
		LOGGER.info("[{}][retrieveExchangeValue][from: {}][to: {}]", this.getClass().getName(), from, to);

		printAllHeaders(headers);

		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

		LOGGER.info("[from: {}][to: {}][exchangeValue: {}]", from, to, exchangeValue);

		if (exchangeValue == null) {
			throw new RuntimeException("Unable to find data to convert " + from + " to " + to);
		}

		exchangeValue.setExchangeEnvironmentInfo(instanceInformationService.retrieveInstanceInfo());

		LOGGER.info("[{}][retrieveExchangeValue][exchangeValue: {}][to: {}]", this.getClass().getName(),
				exchangeValue.toString());
		return exchangeValue;
	}

	private void printAllHeaders(Map<String, String> headers) {
		headers.forEach((key, value) -> {
			LOGGER.info(String.format("Header '%s' = %s", key, value));
		});
	}
}
