package com.kdk.app.jpa.specification;

import org.springframework.data.jpa.domain.Specification;

import com.kdk.app.jpa.entity.City;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

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
public class CitySpecifications {

    public static Specification<City> hasCountryCode(String countryCode) {
        return new Specification<City>() {

			private static final long serialVersionUID = 1L;

			@Override
            public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if ( countryCode == null || countryCode.isEmpty() || countryCode.isBlank() ) {
					return cb.conjunction();
				}
                return cb.equal(root.get("countryCode"), countryCode);
            }
        };
    }

    public static Specification<City> hasPopulationGreaterThan(Integer population) {
        return new Specification<City>() {

			private static final long serialVersionUID = 1L;

			@Override
            public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if ( population == null ) {
					return cb.conjunction();
				}
                return cb.greaterThanOrEqualTo(root.get("population"), population);
            }
        };
    }

}
