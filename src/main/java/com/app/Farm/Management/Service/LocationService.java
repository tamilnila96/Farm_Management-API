package com.app.Farm.Management.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Farm.Management.entity.Country;
import com.app.Farm.Management.entity.District;
import com.app.Farm.Management.entity.State;
import com.app.Farm.Management.repository.CountryRepository;
import com.app.Farm.Management.repository.DistrictRepository;
import com.app.Farm.Management.repository.StateRepository;

@Service

public class LocationService {

	@Autowired private CountryRepository countryrepo;
	@Autowired private StateRepository staterepo;
	@Autowired private DistrictRepository districtrepo;
	
	public Country create(Country country ) {
		return countryrepo.save(country);
	}
	
	public State create(State state) {
		UUID countryid = state.getCountry().getId();
		Country country = countryrepo.findById(countryid).orElseThrow(() -> new RuntimeException("Country not found"));
		
		state.setCountry(country);
		return staterepo.save(state);
	}
	
	public District create(District district) {
		UUID StateId = district.getState().getId();
		State state = staterepo.findById(StateId).orElseThrow(() -> new RuntimeException("State not found"));
		district.setState(state);
		return districtrepo.save(district);
	}
	
	
	public List<Country>getAll(){
		return countryrepo.findAll();
	}
	
	public List<State> getStatesbyCountryId(UUID id){
		return staterepo.findByCountryId(id);
	}
	
	public List<District> getDistrictsbyStateId(UUID id){
		return districtrepo.findByStateId(id);
	}
	
	public Country updateCountry(UUID id, Country updatedCountry) {
		Country existingcountry = countryrepo.findById(id).
				orElseThrow(() -> new RuntimeException("Country not found"));
		existingcountry.setName(updatedCountry.getName());
		if(updatedCountry.getState()!=null) {
			for(State state:updatedCountry.getState()) {
				state.setCountry(existingcountry);
			}
			existingcountry.setState(updatedCountry.getState());		
			
		}
		return countryrepo.save(existingcountry);
	}
	
	public State updatedState(UUID id, State updatedState) {
		State existingState = staterepo.findById(id).orElseThrow(()-> new RuntimeException("State not found");
		existingstate.
	}
}