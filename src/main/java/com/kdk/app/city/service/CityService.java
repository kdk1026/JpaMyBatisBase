package com.kdk.app.city.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.kdk.app.city.service.vo.CityParamVo;
import com.kdk.app.jpa.entity.City;

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
public interface CityService {

	public List<City> findAll();

	public Optional<City> findById(Integer id);

	public City save(City city);

	public void removeById(Integer id);

	public int getNextId();

	public List<City> findByCountryCode(String countryCode);

	public Page<City> findAllCities(int page, int size);

	public Page<City> findCitiesByCriteria(CityParamVo vo);

}
