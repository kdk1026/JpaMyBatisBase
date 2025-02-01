package com.kdk.app.city.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdk.app.city.service.CityService;
import com.kdk.app.city.service.vo.CityParamVo;
import com.kdk.app.jpa.entity.City;
import com.kdk.app.jpa.repository.CityRepository;
import com.kdk.app.jpa.specification.CitySpecifications;

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
	public List<City> findAll() {
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

	@Override
	public Page<City> findAllCities(int page, int size) {
		Pageable pageable = PageRequest.of(page -1, size);
		return cityRepository.findAll(pageable);
	}

	@Override
	public Page<City> findCitiesByCriteria(CityParamVo vo) {
		Pageable pageable = PageRequest.of(vo.getCurrentPage() -1, vo.getPageSize());

        Specification<City> spec = Specification
                .where(CitySpecifications.hasCountryCode(vo.getCountryCode()))
                .and(CitySpecifications.hasPopulationGreaterThan(vo.getPopulation()));

        return cityRepository.findAll(spec, pageable);
	}

}
