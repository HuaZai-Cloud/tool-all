package cn.threesides.exception;

import cn.threesides.constant.enums.ResponseResultCodeEnum;
import cn.threesides.beans.BeanEnum;

/**
 * SystemException
 *
 * @author Di Wu
 * @since 2023-04-09
 */
public class SystemException extends BaseException{

	/**
	 * 系统异常
	 *
	 * @param errMessage 异常信息
	 */
	public SystemException(Object errMessage) {
		super(errMessage, ResponseResultCodeEnum.SYSTEM_ERROR.getKey());
	}

	/**
	 * 系统异常
	 *
	 * @param errMessage 异常信息
	 * @param errCode 异常状态
	 */
	public SystemException(Object errMessage, Object errCode) {
		super(errMessage, errCode);
	}

	/**
	 * 系统异常
	 *
	 * @param errMessage 异常信息
	 * @param cause 原因
	 */
	public SystemException(Object errMessage, Throwable cause) {
		super(errMessage, cause, ResponseResultCodeEnum.SYSTEM_ERROR.getKey());
	}

	/**
	 * 系统异常
	 *
	 * @param errMessage 异常信息
	 * @param cause 原因
	 * @param errCode 异常状态
	 */
	public SystemException(Object errMessage, Throwable cause, Object errCode) {
		super(errMessage, cause, errCode);
	}

	/**
	 * 系统异常
	 *
	 * @param beanEnum 基础枚举
	 */
	public SystemException(BeanEnum beanEnum) {
		super(beanEnum.getValue(),  beanEnum.getKey());
	}

	/**
	 * 系统异常
	 *
	 * @param cause 原因
	 * @param beanEnum 基础枚举
	 */
	public SystemException(Throwable cause,BeanEnum beanEnum) {
		super(beanEnum.getValue(), cause, beanEnum.getKey());
	}
}
