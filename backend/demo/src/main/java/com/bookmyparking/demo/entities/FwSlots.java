package com.bookmyparking.demo.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "fw_slots")
@NamedQuery(name = "FwSlots.findAll", query = "SELECT a FROM FwSlots a")
public class FwSlots {

	@EmbeddedId
	private FwSlotsPK id;

	@Column(name = "is_available")
	private boolean isAvailable;

	@Column(name = "reservation_time")
	private int reservationTime;

//	@ManyToOne
//	@JoinColumn(name="id",referencedColumnName="id", insertable=false, updatable=false)
//	private Area area;

	public FwSlots() {
	}

	public FwSlotsPK getId() {
		return id;
	}

	public void setId(FwSlotsPK id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(int reservationTime) {
		this.reservationTime = reservationTime;
	}

//	public Area getArea() {
//		return area;
//	}
//
//	public void setArea(Area area) {
//		this.area = area;
//	}
}
