package com.bookmyparking.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyparking.demo.entities.FwSlots;
import com.bookmyparking.demo.entities.TwSlots;
import com.bookmyparking.demo.entities.UserInfo;
import com.bookmyparking.demo.repositories.FwSlotsRepository;
import com.bookmyparking.demo.repositories.LoginRepository;
import com.bookmyparking.demo.repositories.SlotsRepository;

@Service
public class SlotsService {
	@Autowired
	SlotsRepository slotsRepository;
	
	@Autowired
	FwSlotsRepository fwSlotsRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
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
	
	public UserInfo deductBalance(UserInfo updatedUser) {
		Optional<UserInfo> user = this.loginRepository.findById(updatedUser.getUserId());
		UserInfo userToBeUpdated = user.get();
		userToBeUpdated.setWalletBalance(updatedUser.getWalletBalance());
		try {
			return this.loginRepository.save(userToBeUpdated);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
