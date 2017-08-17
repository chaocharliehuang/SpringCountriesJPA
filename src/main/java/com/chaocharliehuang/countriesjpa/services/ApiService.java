package com.chaocharliehuang.countriesjpa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chaocharliehuang.countriesjpa.models.*;
import com.chaocharliehuang.countriesjpa.repositories.*;

@Service
public class ApiService {
	
	private CountryRepository countryRepository;
	private LanguageRepository languageRepository;
	private CityRepository cityRepository;
	
	public ApiService(
			CountryRepository countryRepository,
			LanguageRepository languageRepository,
			CityRepository cityRepository) {
		this.countryRepository = countryRepository;
		this.languageRepository = languageRepository;
		this.cityRepository = cityRepository;
	}

	public List<Object[]> findCountriesSpeakingSlovene() {
		return countryRepository.findCountriesSpeakingSlovene();
	}
	
	public List<Object[]> findCitiesCountByCountry() {
		return countryRepository.findCitiesCountByCountry();
	}
	
	public List<City> findMexicanCities() {
		return cityRepository.findMexicanCities();
	}
	
	public List<Object[]> findLargeLanguagePercentageByCountry() {
		return countryRepository.findLargeLanguagePercentageByCountry();
	}
	
	public List<Country> findSmallCountries() {
		return countryRepository.findSmallCountries();
	}
	
	public List<Country> findConstMonarchCountries() {
		return countryRepository.findConstMonarchCountries();
	}
	
	public List<City> findBuenosAiresCities() {
		return cityRepository.findBuenosAiresCities();
	}
	
	public List<Object[]> findCountriesByRegion() {
		return countryRepository.findCountriesByRegion();
	}
}
