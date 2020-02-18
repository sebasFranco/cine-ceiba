package com.ceiba.adn.infrastructure.adapter.jpa.bd;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.ChairEntity;
import com.ceiba.adn.infrastructure.adapter.jpa.jparepository.JpaChairRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.mapper.ChairMapper;

@Repository
@Transactional
public class ChairRepositoryJpa implements ChairRepository {

	
	private JpaChairRepository repositoryChair;

	@Autowired
    public ChairRepositoryJpa (JpaChairRepository repositoryChair){
        this.repositoryChair = repositoryChair;
    }
	
	@Override
	public List<Chair> findAll() {
		List<Chair> sillas = new ArrayList<>();
		List<ChairEntity> entityList = repositoryChair.findAll();
		entityList.forEach(value -> sillas.add(ChairMapper.entityToDomain(value)));
		return sillas;
	}

	@Override
	public Chair save(Chair chair) {
		chair.setStatus((chair.isStatus())?false:true);
		return ChairMapper.entityToDomain(repositoryChair.save(ChairMapper.domainToEntity(chair)));
	}
	
	@Override
	public Chair findById(Long id) {
		return ChairMapper.entityToDomain(repositoryChair.getOne(id));
	}
}
