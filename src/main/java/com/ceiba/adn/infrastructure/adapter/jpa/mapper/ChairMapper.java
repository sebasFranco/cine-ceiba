package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.ChairEntity;

public final class ChairMapper {
	
	private ChairMapper() {}

	public static Chair entityToDomain(ChairEntity entity) {
        return new Chair(entity.getId(),entity.getName(),entity.getStatus());
    }

    public static ChairEntity domainToEntity(Chair domain) {
    	return new ChairEntity(domain.getId(),domain.getName(),domain.getStatus());
    }
}
