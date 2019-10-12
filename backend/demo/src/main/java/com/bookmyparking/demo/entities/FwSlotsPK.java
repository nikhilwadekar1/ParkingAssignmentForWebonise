package com.bookmyparking.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FwSlotsPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="area_id")
	private int areaId;
	
	@Column(name="city_id", insertable=false, updatable=false)
	private int cityId;
	
	@Column(name="fw_slots_id")
	private int fwSlotsId;

	public FwSlotsPK() {
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getFwSlotsId() {
		return fwSlotsId;
	}

	public void setFwSlotsId(int fwSlotsId) {
		this.fwSlotsId = fwSlotsId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + areaId;
		result = prime * result + cityId;
		result = prime * result + fwSlotsId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FwSlotsPK other = (FwSlotsPK) obj;
		if (areaId != other.areaId)
			return false;
		if (cityId != other.cityId)
			return false;
		if (fwSlotsId != other.fwSlotsId)
			return false;
		return true;
	}
	
	

}
