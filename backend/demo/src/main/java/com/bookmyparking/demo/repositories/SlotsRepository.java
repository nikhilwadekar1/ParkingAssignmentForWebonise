package com.bookmyparking.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookmyparking.demo.entities.TwSlots;
import com.bookmyparking.demo.entities.TwSlotsPK;

public interface SlotsRepository extends CrudRepository<TwSlots, TwSlotsPK> {
	public List<TwSlots> findAllByIdAreaIdAndIdCityId(int areaId, int cityId);
}
