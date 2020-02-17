package com.ceiba.adn.domain.ports;

import java.util.List;

import com.ceiba.adn.domain.model.Chair;

public interface ChairRepository {

	List<Chair> findAll();

	public Chair findById(Long id);

	public Chair save(Chair chair);

}
