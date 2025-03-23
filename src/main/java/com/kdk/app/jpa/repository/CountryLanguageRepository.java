package com.kdk.app.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, Integer>, JpaSpecificationExecutor<CountryLanguage> {

}
