package com.kdk.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
@SpringBootTest
class CityCountryServiceTest {

	@Autowired
	private CityCountryService cityCountryService;

	@Test
	void testCityCountry() {
		List<CityCountryVo> list = cityCountryService.getCityCountry();
		System.out.println(list.size());
		assertTrue(true);
	}

}
