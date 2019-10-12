package com.bookmyparking.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TwSlotsPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="area_id")
	private int areaId;
	
	@Column(name="city_id", insertable=false, updatable=false)
	private int cityId;
	
	@Column(name="tw_slots_id")
	private int twSlotsId;

	public TwSlotsPK() {
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

	public int getTwSlotsId() {
		return twSlotsId;
	}

	public void setTwSlotsId(int twSlotsId) {
		this.twSlotsId = twSlotsId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + areaId;
		result = prime * result + cityId;
		result = prime * result + twSlotsId;
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
		TwSlotsPK other = (TwSlotsPK) obj;
		if (areaId != other.areaId)
			return false;
		if (cityId != other.cityId)
			return false;
		if (twSlotsId != other.twSlotsId)
			return false;
		return true;
	}
	
	

}
