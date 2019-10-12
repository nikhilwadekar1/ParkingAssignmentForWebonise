package com.bookmyparking.demo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the area database table.
 * 
 */
@Embeddable
public class AreaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="area_id")
	private int areaId;

	@Column(name="city_id", insertable=false, updatable=false)
	private int cityId;

	public AreaPK() {
	}
	public int getAreaId() {
		return this.areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public int getCityId() {
		return this.cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AreaPK)) {
			return false;
		}
		AreaPK castOther = (AreaPK)other;
		return 
			(this.areaId == castOther.areaId)
			&& (this.cityId == castOther.cityId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.areaId;
		hash = hash * prime + this.cityId;
		
		return hash;
	}
}