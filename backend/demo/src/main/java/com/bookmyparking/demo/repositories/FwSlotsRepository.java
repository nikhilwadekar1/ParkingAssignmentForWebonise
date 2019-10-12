package com.bookmyparking.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookmyparking.demo.entities.FwSlots;
import com.bookmyparking.demo.entities.FwSlotsPK;

public interface FwSlotsRepository extends CrudRepository<FwSlots, FwSlotsPK> {
	public List<FwSlots> findAllByIdAreaIdAndIdCityId(int areaId, int cityId);
}