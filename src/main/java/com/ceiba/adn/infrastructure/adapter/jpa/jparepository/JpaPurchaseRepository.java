package com.ceiba.adn.infrastructure.adapter.jpa.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.PurchaseEntity;

public interface JpaPurchaseRepository extends JpaRepository<PurchaseEntity, Long>{
}
