package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.PurchaseEntity;

import java.util.List;

@Mapper
public interface PurchaseMapper {

	PurchaseMapper MAPPER = Mappers.getMapper(PurchaseMapper.class);

	Purchase toPurchase(PurchaseEntity purchaseEntity);

	List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntity);

	PurchaseEntity toPurchaseEntity(Purchase purchase);

}
