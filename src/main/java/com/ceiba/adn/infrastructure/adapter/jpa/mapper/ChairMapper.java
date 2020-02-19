package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.ChairEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChairMapper {

	@Mappings({
	      @Mapping(target="id", source="chairEntity.id"),
	      @Mapping(target="name", source="chairEntity.name"),
	      @Mapping(target="status", source="chairEntity.status")
	    })
	Chair toChair(ChairEntity chairEntity);

	List<Chair> toChairs(List<ChairEntity> chairsEntity);

	ChairEntity toChairEntity(Chair chair);

}
