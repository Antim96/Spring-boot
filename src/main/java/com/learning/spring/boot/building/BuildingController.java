package com.learning.spring.boot.building;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/building")
public class BuildingController {
	
	
	

	@Autowired
	BuildingRepository buildingResository;

	@PostMapping("/add")
	public String save(@RequestBody Building building) {
				
		buildingResository.save(building);
		//buildingResository.save(building);
		return "Success";
	}



	@GetMapping("/all")
	public List<Building> show() {		
		return (List<Building>) buildingResository.findAll();
	}


	@DeleteMapping("/delete/{id}")
	public String del(@PathVariable String id) {
		Building b = buildingResository.findById(id).get();
		if(b!= null) {
			buildingResository.delete(b);
			return "Success";
		}
		else
			return "Not Found";
	}

	@PutMapping("/update/{id}")
	public String update(@PathVariable String id, @RequestBody Building building) {

		Building b = buildingResository.findById(id).get();
		if(b!= null) {

			buildingResository.save(building);
			return "Succesfully Updated";
		}
		else
			return "Not found";
	}

}
