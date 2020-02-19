package com.ceiba.adn.infrastructure.adapter.jpa.bd;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;
import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.ChairEntity;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.PurchaseEntity;
import com.ceiba.adn.infrastructure.adapter.jpa.jparepository.JpaPurchaseRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.mapper.ChairMapper;
import com.ceiba.adn.infrastructure.adapter.jpa.mapper.PurchaseMapper;

@Repository
@Transactional
public class PurchaseRepositoryJpa implements PurchaseRepository {

	private JpaPurchaseRepository repositoryPurchase;

	private ChairRepository repositoryChair;

	public PurchaseRepositoryJpa() {
		super();
	}

	public PurchaseRepositoryJpa(ChairRepository repositoryChair) {
		super();
		this.repositoryChair = repositoryChair;
	}

	public PurchaseRepositoryJpa(JpaPurchaseRepository repositoryPurchase) {
		super();
		this.repositoryPurchase = repositoryPurchase;
	}


	@Override
	public List<Purchase> findAll() {
		List<Purchase> purchases = new ArrayList<>();
		List<PurchaseEntity> purchasesEntity = repositoryPurchase.findAll();
		purchasesEntity.forEach(value -> purchases.add(PurchaseMapper.entityToDomain(value)));
		return purchases;
	}

	@Override
	public Purchase findById(Long id) {
		return PurchaseMapper.entityToDomain(repositoryPurchase.getOne(id));
	}

	@Override
	public Purchase save(Purchase purchase) {
		repositoryChair.save(repositoryChair.findById(purchase.getChair()));
		return purchase;
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		repositoryChair.save(repositoryChair.findById(purchase.getChair()));
		repositoryPurchase.deleteById(purchase.getId());
	}
}
