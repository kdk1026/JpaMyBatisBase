package com.kdk.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kdk.app.city.service.CountryLanguageService;
import com.kdk.app.jpa.entity.CountryLanguage;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2025. 3. 23. kdk	최초작성
 * </pre>
 *
 *
 * @author kdk
 */
@SpringBootTest
class CountryLanguageTest {

	@Autowired
	private CountryLanguageService countryLanguageService;

	@Test
	void testSave() {
		CountryLanguage countryLanguage = new CountryLanguage();
		countryLanguage.setCountryCode("KOR");
		countryLanguage.setLanguage("Korean");
		countryLanguage.setIsOfficial("T");
		countryLanguage.setPercentage(100);

		countryLanguageService.save(countryLanguage);
		assertTrue(true);
	}

}
