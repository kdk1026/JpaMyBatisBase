package com.kdk.app.city.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdk.app.city.service.CityService;
import com.kdk.app.jpa.entity.City;
import com.kdk.app.jpa.repository.CityRepository;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2025. 2. 1. kdk	최초작성
 * </pre>
 *
 *
 * @author kdk
 */
@Transactional(transactionManager = "jpaTransactionManager")
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> findAl() {
		return cityRepository.findAll();
	}

	@Override
	public Optional<City> findById(Integer id) {
		return cityRepository.findById(id);
	}

	@Transactional("jpaTransactionManager")
	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public void removeById(Integer id) {
		cityRepository.deleteById(id);
	}


	@Override
	public int getNextId() {
		return cityRepository.getNextId();
	}

	@Override
	public List<City> findByCountryCode(String countryCode) {
		return cityRepository.findByCountryCode(countryCode);
	}

}
