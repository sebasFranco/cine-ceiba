package com.ceiba.adn.infrastructure.adapter.jpa.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.ChairEntity;

public interface JpaChairRepository extends JpaRepository<ChairEntity, Long>{
}
