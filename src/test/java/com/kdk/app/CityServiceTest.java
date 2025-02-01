package com.kdk.app;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kdk.app.city.service.CityService;
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
public class CityServiceTest {

	@Autowired
	private CityService cityService;

//	@Test
	public void testFindAll() {
		List<City> list = cityService.findAl();
		System.out.println(list.size());
	}

//	@Test
	public void testFindId() {
		Optional<City> city = cityService.findById(1);
		System.out.println(city.get());
	}

	@Test
	public void testSave() {
		City city = new City();
		city.setId(cityService.getNextId());
		city.setName("Test");
		city.setCountryCode("AFG");
		city.setDistrict("Test");
		city.setPopulation(1);

		cityService.save(city);
	}

//	@Test
	public void testRemoveById() {
		cityService.removeById(4080);
	}

//	@Test
	public void testfindByCountryCode() {
		List<City> list = cityService.findByCountryCode("AFG");
		System.out.println(list.size());
	}

}
