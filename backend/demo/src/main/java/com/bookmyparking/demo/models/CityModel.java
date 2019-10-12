package com.bookmyparking.demo.models;

public class CityModel {
	private Integer cityId;
	private String cityName;
	public CityModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CityModel(Integer cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
