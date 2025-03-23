package com.kdk.app.city.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.kdk.app.city.service.CityService;
import com.kdk.app.city.vo.CityParamVo;
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
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		Pageable pageable = PageRequest.of(vo.getCurrentPage() -1, vo.getPageSize(), sort);

        Specification<City> spec = Specification
                .where(CitySpecifications.hasCountryCode(vo.getCountryCode()))
                .and(CitySpecifications.hasPopulationGreaterThanOrEqualTo(vo.getPopulation()));

        return cityRepository.findAll(spec, pageable);
	}

	@Override
	public void modify(City modifyCity) {
		City city = cityRepository.findById(modifyCity.getId()).orElseThrow(new Supplier<RuntimeException>() {

			@Override
			public RuntimeException get() {
				return new RuntimeException("City not found");
			}

		});

		if ( !ObjectUtils.isEmpty(modifyCity.getName()) ) {
			city.setName(modifyCity.getName());
		}

		if ( !ObjectUtils.isEmpty(modifyCity.getCountryCode()) ) {
			city.setCountryCode(modifyCity.getCountryCode());
		}

		if ( !ObjectUtils.isEmpty(modifyCity.getDistrict()) ) {
			city.setDistrict(modifyCity.getDistrict());
		}

		if ( !ObjectUtils.isEmpty(modifyCity.getPopulation()) && modifyCity.getPopulation() > 0 ) {
			city.setPopulation(modifyCity.getPopulation());
		}

		cityRepository.save(city);
	}

}
