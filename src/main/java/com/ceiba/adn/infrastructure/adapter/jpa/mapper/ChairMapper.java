package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.ChairEntity;

public class ChairMapper {

	public static Chair entityToDomain(ChairEntity entity) {
        Chair domain = new Chair();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setStatus(entity.isStatus());
        return domain;
    }

    public static ChairEntity domainToEntity(Chair domain) {
        ChairEntity entity = new ChairEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setStatus(domain.isStatus());
        return entity;
    }
}
