package com.chaocharliehuang.countriesjpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chaocharliehuang.countriesjpa.models.*;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	@Query("SELECT cities FROM Country c JOIN c.cities cities "
			+ "WHERE c.name = 'Mexico' AND cities.population > 500000 "
			+ "ORDER BY cities.population DESC")
	List<City> findMexicanCities();
	
	@Query("SELECT cities FROM Country c JOIN c.cities cities "
			+ "WHERE c.name = 'Argentina' AND cities.district = 'Buenos Aires' "
			+ "AND cities.population > 500000 ORDER BY cities.population DESC")
	List<City> findBuenosAiresCities();
}
