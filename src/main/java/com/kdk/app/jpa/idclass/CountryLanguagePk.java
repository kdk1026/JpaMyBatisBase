package com.kdk.app.jpa.idclass;

import java.io.Serializable;

import lombok.Data;

@Data
public class CountryLanguagePk implements Serializable {

	private static final long serialVersionUID = 1L;

	private String countryCode;
	private String language;

}
