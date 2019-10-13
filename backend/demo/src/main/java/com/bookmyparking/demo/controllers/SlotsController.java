package com.bookmyparking.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyparking.demo.entities.FwSlots;
import com.bookmyparking.demo.entities.TwSlots;
import com.bookmyparking.demo.entities.UserInfo;
import com.bookmyparking.demo.models.Message;
import com.bookmyparking.demo.services.SlotsService;

@CrossOrigin(origins = "*")
@RestController
public class SlotsController {
	@Autowired
	SlotsService slotsService;
	
	@PostMapping("/reserveSlot")
	public Message reserveSlot(@RequestBody TwSlots slot) {
		TwSlots reservedSlot = this.slotsService.reserveSlot(slot);
		if(reservedSlot != null)
			return new Message("Reserved successfully!", "alert alert-success");
		else
			return new Message("There is some problem at our side!", "alert alert-danger");
	}
	
	@PostMapping("/reserveFwSlot")
	public Message reserveFwSlot(@RequestBody FwSlots slot) {
		FwSlots reservedSlot = this.slotsService.reserveFwSlot(slot);
		if(reservedSlot != null)
			return new Message("Reserved successfully!", "alert alert-success");
		else
			return new Message("There is some problem at our side!", "alert alert-danger");
	}
	
	@PostMapping("/deductBalance")
	public UserInfo deductWalletBalance(@RequestBody UserInfo updatedUser) {
		return this.slotsService.deductBalance(updatedUser);
	}
}
