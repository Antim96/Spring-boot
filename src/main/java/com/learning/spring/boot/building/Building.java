package com.learning.spring.boot.building;

import java.util.List;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;



@Document
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
public class Building {

	@Id
	private String id;
	
	@Field
	private String name;
	
	@Field
	private String companyId;
	
	public Building() {
		
	}

	public Building(String id, String name, String companyId) {
		this.id = id;
		this.name = name;
		this.companyId = companyId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	
}
