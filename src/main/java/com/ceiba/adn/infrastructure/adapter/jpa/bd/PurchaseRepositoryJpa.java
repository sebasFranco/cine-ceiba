package com.ceiba.adn.infrastructure.adapter.jpa.bd;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	public PurchaseRepositoryJpa(JpaPurchaseRepository repositoryPurchase) {
		this.repositoryPurchase = repositoryPurchase;
	}

	@Autowired
	private ChairRepository repositoryChair;

	@Override
	public List<Purchase> findAll() {
		return PurchaseMapper.MAPPER.toPurchases(repositoryPurchase.findAll()) ;
	}

	@Override
	public Purchase findById(Long id) {
		return PurchaseMapper.MAPPER.toPurchase(repositoryPurchase.getOne(id));
	}

	@Override
	public Purchase save(Purchase purchase) {
		repositoryChair.save(repositoryChair.findById(purchase.getChair()));
		return PurchaseMapper.MAPPER.toPurchase(repositoryPurchase.save(PurchaseMapper.MAPPER.toPurchaseEntity(purchase)));
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		repositoryChair.save(repositoryChair.findById(purchase.getChair()));
		repositoryPurchase.deleteById(PurchaseMapper.MAPPER.toPurchaseEntity(purchase).getId());
	}
}
