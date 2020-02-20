package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.PurchaseEntity;

public class PurchaseMapper {

	public static Purchase entityToDomain(PurchaseEntity entity) {
		return new Purchase(entity.getId(), entity.getChair(), entity.getIdClient(), entity.getPurchaseTime(),
				entity.getPurchaseDay(), entity.getTotal());
	}

	public static PurchaseEntity domainToEntity(Purchase domain) {
		return new PurchaseEntity(domain.getId(), domain.getChair(), domain.getIdClient(), domain.getPurchaseTime(),
				domain.getPurchaseDay(), domain.getTotal());
	}
}
