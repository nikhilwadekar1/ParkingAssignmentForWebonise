package com.bookmyparking.demo.models;

import com.bookmyparking.demo.entities.TwSlots;

public class TwSlotBookingModel {
	private TwSlots twSlots;
	private int userId;

	public TwSlotBookingModel() {

	}
	
	public TwSlotBookingModel(TwSlots slot, int userId) {
		this.twSlots = slot;
		this.userId = userId;
	}

	public TwSlots getTwSlots() {
		return twSlots;
	}

	public void setTwSlots(TwSlots twSlots) {
		this.twSlots = twSlots;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
