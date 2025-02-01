package com.kdk.app.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
public interface CityRepository extends JpaRepository<City, Integer> {

    /**
     * city 테이블명이 아닌 Entity 클래스명
     * @return
     */
    @Query("SELECT IFNULL(MAX(c.id), 0) + 1 FROM City c")
    int getNextId();

	List<City> findByCountryCode(String countryCode);

}
