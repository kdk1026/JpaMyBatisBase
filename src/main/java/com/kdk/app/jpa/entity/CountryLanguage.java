package com.kdk.app.jpa.entity;

import com.kdk.app.jpa.idclass.CountryLanguagePk;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Entity
@IdClass(CountryLanguagePk.class)
@Table(name = "countrylanguage")
@Getter
@Setter
@ToString
public class CountryLanguage {

	@Id
	@Column(name = "CountryCode")
	private String countryCode;

	@Id
	@Column(name = "Language")
	private String language;

	@Column(name = "IsOfficial")
	private String isOfficial;

	@Column(name = "Percentage")
	private Integer percentage;

}
