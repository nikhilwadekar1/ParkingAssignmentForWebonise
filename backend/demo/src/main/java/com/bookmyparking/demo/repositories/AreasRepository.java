package com.bookmyparking.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookmyparking.demo.entities.Area;
import com.bookmyparking.demo.entities.AreaPK;

public interface AreasRepository extends CrudRepository<Area, AreaPK> {
	public List<Area> findAllByCityCityId(Integer cityId);
}
