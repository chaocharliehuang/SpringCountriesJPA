package com.chaocharliehuang.countriesjpa.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chaocharliehuang.countriesjpa.models.*;
import com.chaocharliehuang.countriesjpa.services.ApiService;

@Controller
public class Countries {
	
	private ApiService apiService;
	
	public Countries(ApiService apiService) {
		this.apiService = apiService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		
		//Find all countries that speak Slovene
		//Return country name, language, and language percentage
		//Order by language percentage in descending order
		List<Object[]> sloveneCountries = apiService.findCountriesSpeakingSlovene();
		model.addAttribute("sloveneCountries", sloveneCountries);
		
		//****RAW SQL QUERY***
		//Find total number of cities for each country
		//Return name of country and total number of cities
		//Order by number of cities in descending order
		List<Object[]> cityCountByCountry = apiService.findCitiesCountByCountry();
		model.addAttribute("cityCountByCountry", cityCountByCountry);
		
		//Find all cities in Mexico with a population greater than 500,000
		//Return city name and population
		//Order by population in descending order
		List<City> mexicanCities = apiService.findMexicanCities();
		model.addAttribute("mexicanCities", mexicanCities);
		
		//Find all languages in each country with a percentage greater than 89%
		//Return country name, language, and language percentage
		//Order by percentage in descending order
		List<Object[]> languagesByCountry = apiService.findLargeLanguagePercentageByCountry();
		model.addAttribute("languagesByCountry", languagesByCountry);
		
		//Find all countries with surface area below 501 and population greater than 100,000
		//Return country name, surface area, and population
		List<Country> smallCountries = apiService.findSmallCountries();
		model.addAttribute("smallCountries", smallCountries);
		
		//Find all countries with only a Constitutional Monarchy,
		//GNP greater than 200, and life expectancy greater than 75 years
		//Return country name, GNP, and life expectancy
		List<Country> constMonarchCountries = apiService.findConstMonarchCountries();
		model.addAttribute("constMonarchCountries", constMonarchCountries);
		
		//Find all cities of Argentina inside the Buenos Aires district
		//with population greater than 500,000
		//Return country name, city name, district, and population
		//Order by population in descending order
		List<City> buenosAiresCities = apiService.findBuenosAiresCities();
		model.addAttribute("buenosAiresCities", buenosAiresCities);
		
		//Find the number of countries in each region
		//Return region name and number of countries
		//Order by number of countries in descending order
		List<Object[]> countriesByRegion = apiService.findCountriesByRegion();
		model.addAttribute("countriesByRegion", countriesByRegion);
		
		return "index.jsp";
	}
}
