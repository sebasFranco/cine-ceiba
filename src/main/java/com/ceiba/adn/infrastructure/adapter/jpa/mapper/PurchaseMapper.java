package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import org.mapstruct.Mapper;

import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.PurchaseEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

	Purchase toPurchase(PurchaseEntity purchaseEntity);

	List<Purchase> toPurchases(List<PurchaseEntity> purchasesEntity);

	PurchaseEntity toPurchaseEntity(Purchase purchase);

}
