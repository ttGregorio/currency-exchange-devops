package br.com.nex2you.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nex2you.api.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
