package com.ceiba.adn.application.caseuse;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.ports.ChairRepository;

@Service
public class LookForChairs {

	private ChairRepository iChairRepository;

	public LookForChairs(ChairRepository iChairRepository) {
		this.iChairRepository = iChairRepository;
	}

	public List<Chair> getAll() {
		return iChairRepository.findAll();
	}
}
