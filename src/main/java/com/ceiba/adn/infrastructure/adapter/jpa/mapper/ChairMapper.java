package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.ChairEntity;

import java.util.List;

@Mapper
public interface ChairMapper {

	ChairMapper MAPPER = Mappers.getMapper(ChairMapper.class);

	Chair toChair(ChairEntity chairEntity);

	List<Chair> toChairs(List<ChairEntity> chairEntity);

	ChairEntity toChairEntity(Chair chair);

}
