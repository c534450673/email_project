package com.subo.common;

import com.subo.Constants.Code;
import com.subo.Constants.Message;
import lombok.Data;

@Data
public class ResponseDTO<T> {

	private Integer code =Code.SUCCESS.value();

	private String subCode;
	
	private String message = Message.SUCCESS.value();

	private T data;

	public ResponseDTO() {
		super();
	}
	public ResponseDTO(Integer code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResponseDTO(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}
