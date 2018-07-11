package com.subo.Constants;

public enum Message {

	SUCCESS("success"),
	
	PARAM_INVALID("��������"),

	SYSTEM_ERROR("系统出错"),

	PARAMS_VALIDATION_FAILED("参数出错"),

	PARAM_MISSING("参数丢失");

	private String value;

	Message(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
	
}
