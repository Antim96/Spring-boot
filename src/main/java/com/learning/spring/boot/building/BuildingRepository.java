package com.learning.spring.boot.building;


import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

@ViewIndexed(designDoc="building")
public interface BuildingRepository extends CouchbaseRepository<Building, String> {


}
