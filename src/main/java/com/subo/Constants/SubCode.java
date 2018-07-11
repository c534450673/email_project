package com.subo.Constants;

public enum SubCode {

	SUCCESS("200"),

	/**
	 * 参数错误
	 * **/
	INVALID_PARAMS("400_1"),

	/**
	 * 参数丢失
	 * **/
	PARAMS_MISSING("400_2");

	private String value;

	SubCode(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
	
}
