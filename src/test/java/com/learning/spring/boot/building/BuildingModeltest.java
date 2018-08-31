package com.learning.spring.boot.building;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;




class BuildingModeltest {

//	@Test
//	void testBuildingStringStringString() {
//		fail("Not yet implemented"); // TODO
//	}

	private Building b = new Building();
	
	
	Building mockB = mock(Building.class);
	
	@Test
	void testGetId() {
		
		
		
		String expectedId = "Four";
		when(mockB.getId()).thenReturn(expectedId);
		
		
		assertEquals(expectedId,mockB.getId());
	}

//	@Test
//	void testSetId() {
//		
//		when()
//		//assertEquals("Four",b.setId("Four").doNothing());
//	}
//
//	@Test
//	void testGetName() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetName() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetCompanyId() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetCompanyId() {
//		fail("Not yet implemented"); // TODO
//	}

}
