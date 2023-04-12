package com.threesides.exception;

import com.threesides.beans.BeanEnum;
import com.threesides.constant.enums.ResponseResultCodeEnum;
import com.threesides.lang.ObjectUtil;

/**
 * ParameterException
 *
 * @author Di Wu
 * @since 2023-04-09
 */
public class SystemException extends BaseException{

	public SystemException(Object errMessage) {
		super(errMessage, ResponseResultCodeEnum.SYSTEM_ERROR.getKey());
	}

	public SystemException(Object errMessage, Object errCode) {
		super(errMessage, errCode);
	}

	public SystemException(Object errMessage, Throwable cause) {
		super(errMessage, cause, ResponseResultCodeEnum.SYSTEM_ERROR.getKey());
	}

	public SystemException(Object errMessage, Throwable cause, Object errCode) {
		super(errMessage, cause, errCode);
	}

	public SystemException(BeanEnum beanEnum) {
		super(beanEnum.getValue(),  beanEnum.getKey());
	}
	public SystemException(Throwable cause,BeanEnum beanEnum) {
		super(beanEnum.getValue(), cause, beanEnum.getKey());
	}
}
