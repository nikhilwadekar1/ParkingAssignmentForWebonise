package com.bookmyparking.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyparking.demo.entities.FwSlots;
import com.bookmyparking.demo.entities.TwSlots;
import com.bookmyparking.demo.repositories.FwSlotsRepository;
import com.bookmyparking.demo.repositories.SlotsRepository;

@Service
public class SlotsService {
	@Autowired
	SlotsRepository slotsRepository;
	
	@Autowired
	FwSlotsRepository fwSlotsRepository;
	
	@Transactional
	public TwSlots reserveSlot(TwSlots slot) {
		Optional<TwSlots> slotToBeReservedOptional = this.slotsRepository.findById(slot.getId());
		TwSlots slotToBeReserved = slotToBeReservedOptional.get();
		slotToBeReserved.setAvailable(false);
		try {
			return this.slotsRepository.save(slotToBeReserved);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	@Transactional
	public FwSlots reserveFwSlot(FwSlots slot) {
		Optional<FwSlots> slotToBeReservedOptional = this.fwSlotsRepository.findById(slot.getId());
		FwSlots slotToBeReserved = slotToBeReservedOptional.get();
		slotToBeReserved.setAvailable(false);
		try {
			return this.fwSlotsRepository.save(slotToBeReserved);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
}
