package com.ceiba.adn.infrastructure.adapter.jpa.bd;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.ChairEntity;
import com.ceiba.adn.infrastructure.adapter.jpa.jparepository.JpaChairRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.mapper.ChairMapper;

@Repository
@Transactional
public class ChairRepositoryJpa implements ChairRepository {

	private ChairMapper chairMapper;

	private JpaChairRepository repositoryChair;

	public ChairRepositoryJpa() {
		super();
	}

	public ChairRepositoryJpa(JpaChairRepository repositoryChair) {
		super();
		this.repositoryChair = repositoryChair;
	}

	public ChairRepositoryJpa(ChairMapper chairMapper, JpaChairRepository repositoryChair) {
		this.chairMapper = chairMapper;
		this.repositoryChair = repositoryChair;
	}

	@Override
	public List<Chair> findAll() {
		List<Chair> chairs = new ArrayList<Chair>();
		for(ChairEntity chairEntity: repositoryChair.findAll()) {
			chairs.add(chairMapper.toChair(chairEntity));
		}
		return chairs;
	}

	@Override
	public Chair save(Chair chair) {
		chair.setStatus((chair.isStatus()) ? false : true);
		return chair;
	}

	@Override
	public Chair findById(Long id) {
		return chairMapper.toChair(repositoryChair.getOne(id));
	}
}
