<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Countries JPA</title>
</head>
<body>
	<h3>Countries that speak Slovene</h3>
	<ul>
	<c:forEach items="${sloveneCountries}" var="row">
		<li>${row[0].name} - ${row[1].language} - ${row[1].percentage}%</li>
	</c:forEach>
	</ul>
	
	<h3>Total number of cities per country</h3>
	<ul>
	<c:forEach items="${cityCountByCountry}" var="row">
		<li>${row[0].name} - ${row[1]}</li>
	</c:forEach>
	</ul>
	
	<h3>Cities in Mexico with population greater than 500,000</h3>
	<ul>
	<c:forEach items="${mexicanCities}" var="row">
		<li>${row.name} - ${row.population}</li>
	</c:forEach>
	</ul>
	
	<h3>Languages in each country with percentage greater than 89%</h3>
	<ul>
	<c:forEach items="${languagesByCountry}" var="row">
		<li>${row[0].name} - ${row[1].language} - ${row[1].percentage}%</li>
	</c:forEach>
	</ul>
	
	<h3>Countries with surface area below 501 and population greater than 100,000</h3>
	<ul>
	<c:forEach items="${smallCountries}" var="row">
		<li>${row.name} - ${row.surface_area} - ${row.population}</li>
	</c:forEach>
	</ul>
	
	<h3>Countries with a Constitutional Monarchy, GNP greater than 200, and life expectancy greater than 75 years</h3>
	<ul>
	<c:forEach items="${constMonarchCountries}" var="row">
		<li>${row.name} - ${row.gnp} - ${row.life_expectancy}</li>
	</c:forEach>
	</ul>
	
	<h3>Cities in Argentina in the Buenos Aires district with population greater than 500,000</h3>
	<ul>
	<c:forEach items="${buenosAiresCities}" var="row">
		<li>${row.country.name} - ${row.name} - ${row.district} - ${row.population}</li>
	</c:forEach>
	</ul>
	
	<h3>Number of countries in each region</h3>
	<ul>
	<c:forEach items="${countriesByRegion}" var="row">
		<li>${row[0].region} - ${row[1]}</li>
	</c:forEach>
	</ul>
</body>
</html>