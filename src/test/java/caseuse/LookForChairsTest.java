package caseuse;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ceiba.adn.application.caseuse.LookForChairs;
import com.ceiba.adn.domain.model.Chair;
import com.ceiba.adn.domain.ports.ChairRepository;

import builder.ChairBuilder;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

class LookForChairsTest {

	private LookForChairs lookForChairs;
	
	@Mock
	private ChairRepository chairRepository;
	
	@BeforeEach
	public void setup (){
        MockitoAnnotations.initMocks(this);
        this.lookForChairs = new LookForChairs(chairRepository);
    }
	
	@Test
    public void findAllTest(){
        //arrange
        List<Chair> chairs = new ArrayList<Chair>();
        
        chairs.add(new ChairBuilder().withId(1L).withName("A1").withStatus(true).build());
        chairs.add(new ChairBuilder().withId(2L).withName("A2").withStatus(true).build());
		        
        when(this.chairRepository.findAll()).thenReturn(chairs);
        //act
        List<Chair> chairResponse = this.lookForChairs.getAll();
        //assert
        Assert.assertEquals(chairs.size(), chairResponse.size());
        Assert.assertEquals( "A1", chairResponse.get(0).getName());
        Assert.assertEquals( "A2", chairResponse.get(1).getName());
    }

}
