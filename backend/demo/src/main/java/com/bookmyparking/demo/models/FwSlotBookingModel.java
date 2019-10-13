package com.bookmyparking.demo.models;

import com.bookmyparking.demo.entities.FwSlots;

public class FwSlotBookingModel {
	private FwSlots fwSlots;
	private int userId;

	public FwSlotBookingModel() {

	}
	
	public FwSlotBookingModel(FwSlots slot, int userId) {
		this.fwSlots = slot;
		this.userId = userId;
	}

	public FwSlots getFwSlots() {
		return fwSlots;
	}

	public void setFwSlots(FwSlots fwSlots) {
		this.fwSlots = fwSlots;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	


}
