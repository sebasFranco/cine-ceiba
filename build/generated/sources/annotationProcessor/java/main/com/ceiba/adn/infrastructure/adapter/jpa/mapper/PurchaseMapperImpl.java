package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import com.ceiba.adn.domain.model.Purchase;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-19T15:56:21-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Override
    public Purchase toPurchase(PurchaseEntity purchaseEntity) {
        if ( purchaseEntity == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        return purchase;
    }

    @Override
    public List<Purchase> toPurchases(List<PurchaseEntity> purchasesEntity) {
        if ( purchasesEntity == null ) {
            return null;
        }

        List<Purchase> list = new ArrayList<Purchase>( purchasesEntity.size() );
        for ( PurchaseEntity purchaseEntity : purchasesEntity ) {
            list.add( toPurchase( purchaseEntity ) );
        }

        return list;
    }

    @Override
    public PurchaseEntity toPurchaseEntity(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        PurchaseEntity purchaseEntity = new PurchaseEntity();

        return purchaseEntity;
    }
}
