package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.PurchaseEntity;

public class PurchaseMapper {
	
	
	
	private PurchaseMapper() {
		super();
	}

	public static Purchase entityToDomain(PurchaseEntity entity) {
		Purchase domain = new Purchase();
		domain.setId(entity.getId());
		domain.setChair(entity.getChair());
		domain.setIdClient(entity.getIdClient());
		domain.setPurchaseTime(entity.getPurchaseTime());
		domain.setPurchaseDay(entity.getPurchaseDay());
		domain.setTotal(entity.getTotal());
		return domain;
	}
	
	public static PurchaseEntity domainToEntity(Purchase domain) {
		PurchaseEntity entity = new PurchaseEntity();
		entity.setId(domain.getId());
		entity.setChair(domain.getChair());
		entity.setIdClient(domain.getIdClient());
		entity.setPurchaseTime(domain.getPurchaseTime());
		entity.setPurchaseDay(domain.getPurchaseDay());
		entity.setTotal(domain.getTotal());
		return entity;
	}
	
}
