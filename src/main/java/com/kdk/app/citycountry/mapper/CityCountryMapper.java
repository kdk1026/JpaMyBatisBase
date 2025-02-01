package com.kdk.app.citycountry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface CityCountryMapper {

	List<CityCountryVo> selectCityCountry();

}
