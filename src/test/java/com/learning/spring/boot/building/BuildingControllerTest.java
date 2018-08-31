package com.learning.spring.boot.building;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingControllerTest {

	@Mock
	BuildingRepository buildingRepository;

	@InjectMocks
	BuildingController bc;

	Building b = new Building("Five","New Apartments","xecy");

	@Test
	public void testSave() {



		when(buildingRepository.save(b)).thenReturn(b);
		assertEquals("Success",bc.save(b));

	}


	@Test
	public void testShow() throws Exception {


		//BuildingRepository buildingRepository = mock(BuildingRepository.class);


		List<Building> b = new ArrayList<>();
		b.add(new Building("Five","New Apartments","xecy"));
		//			List<Building> l = null ;
		//			l.add(0, b);


		when((List<Building>)buildingRepository.findAll()).thenReturn((List<Building>) b);

		//System.out.println(bc.show().get(0));
		assertEquals((List<Building>) b,bc.show());
		assertNotEquals("Success", bc.show());
	}





	@Test(expected = NoSuchElementException.class)
	public void testDel() throws Exception{

		Building c = new Building("Five","New Apartments","xecy");
		String id = "Five";

		try {
			//when(buildingRepository.findById("Five").get());
			
			when(buildingRepository.findById(id).get()).thenReturn(c);
			doNothing().when(buildingRepository).delete(c);
			assertEquals("Success",bc.del(id));			
		}
		
		catch(NoSuchElementException e) {
			assertEquals("Not Found", bc.del(id));
		
		}

			
	}

	
	
	@Test(expected = NoSuchElementException.class)
	public void testUpdate() {
		String id = "Five";
	
		when(buildingRepository.findById(id).get()).thenThrow(new NoSuchElementException());
		when(buildingRepository.save(b)).thenReturn(b);
			assertEquals("Succesfully Updated",bc.update(id,b));
			assertEquals("Not found",bc.update(id,b));
			
		}
		

}
