package com.ceiba.adn.infrastructure.adapter.jpa.mapper;

import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.infrastructure.adapter.jpa.jpaentity.ChairEntity;
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
public class ChairMapperImpl implements ChairMapper {

    @Override
    public Chair toChair(ChairEntity chairEntity) {
        if ( chairEntity == null ) {
            return null;
        }

        Chair chair = new Chair();

        chair.setStatus( chairEntity.isStatus() );
        chair.setId( chairEntity.getId() );
        chair.setName( chairEntity.getName() );

        return chair;
    }

    @Override
    public List<Chair> toChairs(List<ChairEntity> chairsEntity) {
        if ( chairsEntity == null ) {
            return null;
        }

        List<Chair> list = new ArrayList<Chair>( chairsEntity.size() );
        for ( ChairEntity chairEntity : chairsEntity ) {
            list.add( toChair( chairEntity ) );
        }

        return list;
    }

    @Override
    public ChairEntity toChairEntity(Chair chair) {
        if ( chair == null ) {
            return null;
        }

        ChairEntity chairEntity = new ChairEntity();

        chairEntity.setName( chair.getName() );
        chairEntity.setStatus( chair.isStatus() );

        return chairEntity;
    }
}
