package com.bookmyparking.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyparking.demo.entities.Area;
import com.bookmyparking.demo.entities.AreaPK;
import com.bookmyparking.demo.entities.City;
import com.bookmyparking.demo.entities.FwSlots;
import com.bookmyparking.demo.entities.TwSlots;
import com.bookmyparking.demo.models.CityModel;
import com.bookmyparking.demo.models.SlotModel;
import com.bookmyparking.demo.repositories.AreasRepository;
import com.bookmyparking.demo.repositories.CitiesRepository;
import com.bookmyparking.demo.repositories.FwSlotsRepository;
import com.bookmyparking.demo.repositories.SlotsRepository;

@CrossOrigin(origins = "*")
@RestController
public class LandingPageController {
	@Autowired
	CitiesRepository landingPageRepository;
	
	@Autowired
	AreasRepository areasRepository;
	
	@Autowired
	SlotsRepository slotsRepository;
	
	@Autowired
	FwSlotsRepository fwSlotsRepository;
	
	@GetMapping("/cities")
	public List<City> getAllCities() {
		return landingPageRepository.findAll();
	}
	
	@PostMapping("/areas")
	public List<Area> getAllAreas(@RequestBody CityModel city ) {
		return this.areasRepository.findAllByCityCityId(city.getCityId());
	}
	
	@PostMapping("/slots")
	public List<TwSlots> getAllTwSlots(@RequestBody SlotModel slot){
		return this.slotsRepository.findAllByIdAreaIdAndIdCityId(slot.getAreaId(), slot.getCityId());
	}
	
	@PostMapping("/fwSlots")
	public List<FwSlots> getAllFwSlots(@RequestBody SlotModel slot){
		return this.fwSlotsRepository.findAllByIdAreaIdAndIdCityId(slot.getAreaId(), slot.getCityId());
	}
}
