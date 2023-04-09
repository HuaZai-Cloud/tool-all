package com.threesides.exception;

import com.threesides.beans.BeanEnum;
import com.threesides.lang.ObjectUtil;

/**
 * ParameterException
 *
 * @author Di Wu
 * @since 2023-04-09
 */
public class ParameterException extends BusinessException{
	public ParameterException(String message) {
		super(message);
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParameterException(Throwable cause) {
		super(cause);
	}
	public ParameterException(BeanEnum beanEnum){
		super(ObjectUtil.objectToUFTF8String(beanEnum.getValue()));
	}
}
