package com.chaocharliehuang.countriesjpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chaocharliehuang.countriesjpa.models.*;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	@Query("SELECT c, l FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' "
			+ "ORDER BY l.percentage DESC")
	List<Object[]> findCountriesSpeakingSlovene();
	
	@Query("SELECT c, count(cities) FROM Country c JOIN c.cities cities GROUP BY c.name "
			+ "ORDER BY count(cities) DESC")
	List<Object[]> findCitiesCountByCountry();
	
	@Query("SELECT c, l FROM Country c JOIN c.languages l WHERE l.percentage > 89 "
			+ "ORDER BY l.percentage DESC")
	List<Object[]> findLargeLanguagePercentageByCountry();
	
	@Query("SELECT c FROM Country c WHERE c.surface_area < 501 AND c.population > 100000")
	List<Country> findSmallCountries();
	
	@Query("SELECT c FROM Country c WHERE c.government_form = 'Constitutional Monarchy' "
			+ "AND c.gnp > 200 AND c.life_expectancy > 75")
	List<Country> findConstMonarchCountries();
	
	@Query("SELECT c, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> findCountriesByRegion();
}
