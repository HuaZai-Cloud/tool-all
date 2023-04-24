package com.threesides.exception;

import com.threesides.beans.BeanEnum;
import com.threesides.constant.enums.ResponseResultCodeEnum;
import com.threesides.lang.ObjectUtil;

/**
 * BusinessException
 *
 * @author Di Wu
 * @since 2023-04-09
 */
public class BusinessException extends BaseException{

	/**
	 * 业务异常
	 *
	 * @param errMessage 异常信息
	 */
	public BusinessException(String errMessage) {
		super(errMessage, ResponseResultCodeEnum.BUSINESS_ERROR.getKey());
	}

	public BusinessException(String errMessage, Object errCode) {
		super(errMessage, errCode);
	}

	public BusinessException(String errMessage, Throwable cause) {
		super(errMessage, cause,ResponseResultCodeEnum.BUSINESS_ERROR.getKey());
	}

	public BusinessException(String errMessage, Throwable cause, Object errCode) {
		super(errMessage, cause, errCode);
	}

	public BusinessException(BeanEnum beanEnum) {
		super(beanEnum.getValue(),  beanEnum.getKey());
	}
	public BusinessException(Throwable cause,BeanEnum beanEnum) {
		super(beanEnum.getValue(), cause, beanEnum.getKey());
	}
}
