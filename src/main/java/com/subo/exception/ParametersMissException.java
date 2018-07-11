package com.subo.exception;

import com.subo.Constants.Code;
import com.subo.Constants.Message;
import com.subo.Constants.SubCode;

public class ParametersMissException extends BaseException {

	private static final long serialVersionUID = -8314153844214324519L;
	private String[] missParams;

	public String[] getMissParams() {
		return missParams;
	}

	public void setMissParams(String[] missParams) {
		this.missParams = missParams;
		formatMessage();
	}
	
	public ParametersMissException() {
		super(Code.PARAM_VALIDATE_FAILED.value(), SubCode.PARAMS_MISSING.value(), Message.PARAM_MISSING.value());
	}
	
	public ParametersMissException(String message) {
		super(Code.PARAM_VALIDATE_FAILED.value(), SubCode.PARAMS_MISSING.value(),message);
	}

	public ParametersMissException(SubCode subCode, String message) {
		super(Code.PARAM_VALIDATE_FAILED.value(), subCode.value(), message);
	}

	public ParametersMissException(Code code, SubCode subCode, String message) {
		super(code.value(), subCode.value(), message);
	}

	public ParametersMissException(Code code, SubCode subCode, String[] missParams) {
		super(code.value(),subCode.value(), SubCode.PARAMS_MISSING.value());
		setMissParams(missParams);
	}


	private void formatMessage() {
		StringBuilder message = new StringBuilder(Message.PARAM_MISSING.value());
		if (null == missParams || missParams.length == 0) {
			setErrorMessage(message.toString());
			return;
		}
		message.append("：[");
		for (int i = 0; i < missParams.length; i++) {
			message.append(missParams[i]);
			if (i < missParams.length - 1) {
				message.append(",");
			}
		}
		message.append("]");
		setErrorMessage(message.toString());
	}

}
