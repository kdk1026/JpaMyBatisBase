package com.kdk.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.kdk.app.city.service.CityService;
import com.kdk.app.city.vo.CityParamVo;
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
@SpringBootTest
class CityServiceTest {

	@Autowired
	private CityService cityService;

//	@Test
	void testFindAll() {
		List<City> list = cityService.findAll();
		System.out.println(list.size());
		assertTrue(true);
	}

//	@Test
	void testFindId() {
		Optional<City> city = cityService.findById(1);
		System.out.println(city.get());
		assertTrue(true);
	}

//	@Test
	void testSave() {
		City city = new City();
		city.setId(cityService.getNextId());
		city.setName("Test");
		city.setCountryCode("AFG");
		city.setDistrict("Test");
		city.setPopulation(1);

		cityService.save(city);
		assertTrue(true);
	}

//	@Test
	void testRemoveById() {
		cityService.removeById(4080);
		assertTrue(true);
	}

//	@Test
	void testfindByCountryCode() {
		List<City> list = cityService.findByCountryCode("AFG");
		System.out.println(list.size());
		assertTrue(true);
	}

//	@Test
	void testFindAllCities() {
		int currentPage = 1;
		int pageSize = 10;

		Page<City> cityPage = cityService.findAllCities(currentPage, pageSize);

		List<City> cityList = cityPage.getContent();

		System.out.println(cityList.size());
		System.out.println("Total Pages: " + cityPage.getTotalPages());
	    System.out.println("Total Elements: " + cityPage.getTotalElements());
	    System.out.println("Current Page Number: " + (cityPage.getNumber() + 1));
	    System.out.println("Number of Elements on Current Page: " + cityPage.getNumberOfElements());
	    assertTrue(true);
	}

//	@Test
	void testFindCitiesByCriteria() {
		CityParamVo vo = new CityParamVo();
		vo.setCurrentPage(1);
		vo.setPageSize(10);
		vo.setCountryCode("AFG");
		vo.setPopulation(100000);

		Page<City> cityPage = cityService.findCitiesByCriteria(vo);

		List<City> cityList = cityPage.getContent();

		System.out.println(cityList.size());
		assertTrue(true);
	}

	@Test
	void testModify() {
		City city = new City();
		city.setId(1);
		city.setName("Korea");

		cityService.modify(city);
		assertTrue(true);
	}

}
