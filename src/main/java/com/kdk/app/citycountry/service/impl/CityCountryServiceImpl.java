package com.kdk.app.citycountry.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdk.app.citycountry.mapper.CityCountryMapper;
import com.kdk.app.citycountry.service.CityCountryService;
import com.kdk.app.citycountry.vo.CityCountryVo;

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
@Transactional(transactionManager = "transactionManager")
@Service
public class CityCountryServiceImpl implements CityCountryService {

	private final CityCountryMapper cityCountryMapper;

	public CityCountryServiceImpl(CityCountryMapper cityCountryMapper) {
		this.cityCountryMapper = cityCountryMapper;
	}

	@Override
	public List<CityCountryVo> getCityCountry() {
		return cityCountryMapper.selectCityCountry();
	}

}
