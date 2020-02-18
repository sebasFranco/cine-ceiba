package com.ceiba.adn.infrastructure.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.domain.ports.PurchaseRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.bd.ChairRepositoryJpa;
import com.ceiba.adn.infrastructure.adapter.jpa.bd.PurchaseRepositoryJpa;
import com.ceiba.adn.infrastructure.adapter.jpa.jparepository.JpaChairRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.jparepository.JpaPurchaseRepository;

@Configuration
public class CaseUseConfiguration {

	@Primary
	@Bean
	public ChairRepository chairRepository(JpaChairRepository repositoryChair) {
		return new ChairRepositoryJpa(repositoryChair);
	}
	
	@Primary
	@Bean
	public PurchaseRepository purchaseRepository(JpaPurchaseRepository repositoryPurchase) {
		return new PurchaseRepositoryJpa(repositoryPurchase);
	}
}
