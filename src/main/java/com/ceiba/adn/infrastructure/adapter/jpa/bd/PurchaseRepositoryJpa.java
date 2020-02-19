package com.ceiba.adn.infrastructure.adapter.jpa.bd;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.domain.ports.PurchaseRepository;
import com.ceiba.adn.domain.ports.ChairRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.jparepository.JpaPurchaseRepository;
import com.ceiba.adn.infrastructure.adapter.jpa.mapper.PurchaseMapper;

@Repository
@Transactional
public class PurchaseRepositoryJpa implements PurchaseRepository {

	private JpaPurchaseRepository repositoryPurchase;

	private PurchaseMapper purchaseMapper;

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

	public PurchaseRepositoryJpa(JpaPurchaseRepository repositoryPurchase, PurchaseMapper purchaseMapper,
			ChairRepository repositoryChair) {
		this.repositoryPurchase = repositoryPurchase;
		this.purchaseMapper = purchaseMapper;
		this.repositoryChair = repositoryChair;
	}

	@Override
	public List<Purchase> findAll() {
		return purchaseMapper.toPurchases(repositoryPurchase.findAll());
	}

	@Override
	public Purchase findById(Long id) {
		return purchaseMapper.toPurchase(repositoryPurchase.getOne(id));
	}

	@Override
	public Purchase save(Purchase purchase) {
		repositoryChair.save(repositoryChair.findById(purchase.getChair()));
		return purchaseMapper.toPurchase(repositoryPurchase.save(purchaseMapper.toPurchaseEntity(purchase)));
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		repositoryChair.save(repositoryChair.findById(purchase.getChair()));
		repositoryPurchase.deleteById(purchaseMapper.toPurchaseEntity(purchase).getId());
	}
}
