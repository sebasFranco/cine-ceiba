package com.ceiba.adn.infrastructure.adapter.jpa.bd;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;
import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.PurchaseEntity;
import com.ceiba.adn.infrastructure.adapter.jpa.jparepository.JpaPurchaseRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.mapper.PurchaseMapper;
 
@Repository
@Transactional
public class PurchaseRepositoryJpa implements PurchaseRepository{
	
	@Autowired
	private JpaPurchaseRepository repositoryPurchase;
	
	@Autowired
	private ChairRepository repositoryChair;
	
	@Override
	public List<Purchase> findAll() {
		List<Purchase> purchases = new ArrayList<>();
		List<PurchaseEntity> entityList = repositoryPurchase.findAll();
		entityList.forEach(value -> purchases.add(PurchaseMapper.entityToDomain(value)));
		return purchases;
	}

	@Override
	public Purchase findById(Long id) {
		return PurchaseMapper.entityToDomain(repositoryPurchase.getOne(id));
	}

	@Override
	public Purchase save(Purchase purchase) {
		repositoryChair.save(repositoryChair.findById(purchase.getChair()));
		return PurchaseMapper.entityToDomain(repositoryPurchase.save(PurchaseMapper.domainToEntity(purchase)));
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		repositoryChair.save(repositoryChair.findById(purchase.getChair()));
		repositoryPurchase.deleteById(PurchaseMapper.domainToEntity(purchase).getId());
	}
}
