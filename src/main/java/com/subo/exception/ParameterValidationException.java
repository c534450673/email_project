package com.subo.exception;

import com.subo.Constants.Code;
import com.subo.Constants.Message;
import com.subo.Constants.SubCode;

/**
 * @author Han Bingjiang
 * @Descrition 参数验证错误 
 * @date:Jun 23, 2017   2:42:45 PM
 */
public class ParameterValidationException extends BaseException {

	private static final long serialVersionUID = 2843157218296823783L;

	public ParameterValidationException() {
		super(Code.PARAM_VALIDATE_FAILED.value(), SubCode.INVALID_PARAMS.value(), Message.PARAMS_VALIDATION_FAILED.value());
	}
	
	public ParameterValidationException( String message) {
		super(Code.PARAM_VALIDATE_FAILED.value(), SubCode.INVALID_PARAMS.value(), message);
	}
	
	public ParameterValidationException(SubCode subCode, String message) {
		super(Code.PARAM_VALIDATE_FAILED.value(), subCode.value(), message);
	}
	
	public ParameterValidationException(Code code, SubCode subCode, String message) {
        super(code.value(), subCode.value(), message);
    }

}
