package com.kdk.app.city.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdk.app.city.service.CountryLanguageService;
import com.kdk.app.jpa.entity.CountryLanguage;
import com.kdk.app.jpa.repository.CountryLanguageRepository;

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
@Transactional(transactionManager = "jpaTransactionManager")
@Service
public class CountryLanguageServiceImpl implements CountryLanguageService {

	@Autowired
	private CountryLanguageRepository countryLanguageRepository;

	@Override
	public CountryLanguage save(CountryLanguage countryLanguage) {
		return countryLanguageRepository.save(countryLanguage);
	}

}
