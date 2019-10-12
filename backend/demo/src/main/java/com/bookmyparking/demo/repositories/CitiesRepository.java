package com.bookmyparking.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookmyparking.demo.entities.City;

public interface CitiesRepository extends CrudRepository<City, Integer> {
	public List<City> findAll();
}
