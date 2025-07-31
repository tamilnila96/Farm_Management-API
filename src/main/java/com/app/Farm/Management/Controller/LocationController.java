package com.app.Farm.Management.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Farm.Management.Service.LocationService;
import com.app.Farm.Management.entity.Country;
import com.app.Farm.Management.entity.District;
import com.app.Farm.Management.entity.State;

@RestController
@RequestMapping(value="/api/locations")

public class LocationController {
	
	@Autowired private LocationService locationservice;
	
	@PostMapping("/countries")
	public ResponseEntity<Country> save(@RequestBody Country country) {
		Country saved =  locationservice.create(country);
		return new ResponseEntity<>(saved , HttpStatus.CREATED);
	}
	
	@PostMapping("/states")
	public ResponseEntity<State> save(@RequestBody State state){
		State saved = locationservice.create(state);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@PostMapping("/districts")
	public ResponseEntity<District> save(@RequestBody District district){
		District saved = locationservice.create(district);
		return new ResponseEntity<>(saved , HttpStatus.CREATED);
	}
	
	@GetMapping("/countries")
	public List<Country> findAllCountries(){
		return locationservice.getAll();
		
}
	
	@GetMapping("/states/{countryId}")
	public List<State> findByCountryId(@PathVariable UUID id ){
		return locationservice.getStatesbyCountryId(id);
	}
	
	@GetMapping("/districts/{StateId}")
	public List<District> findByStateId(@PathVariable UUID id){
		return locationservice.getDistrictsbyStateId(id);
	}
}
