package com.subo.Constants;

public enum Code {

	SUCCESS(200),

	SYSTEM_ERROR(417),

	PARAM_VALIDATE_FAILED(400);

	private Integer value;

	Code(Integer value) {
		this.value = value;
	}

	public Integer value() {
		return value;
	}

}
