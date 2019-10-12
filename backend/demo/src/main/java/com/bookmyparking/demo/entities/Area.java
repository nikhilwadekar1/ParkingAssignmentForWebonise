package com.bookmyparking.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AreaPK id;

	@Column(name="area_name")
	private String areaName;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="city_id",referencedColumnName="city_id", insertable=false, updatable=false)
	private City city;

	public Area() {
	}

	public AreaPK getId() {
		return this.id;
	}

	public void setId(AreaPK id) {
		this.id = id;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}