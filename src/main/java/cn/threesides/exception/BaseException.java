package cn.threesides.exception;

import cn.threesides.lang.ObjectUtil;

/**
 * BaseException
 *
 * @author Di Wu
 * @since 2023-04-12
 */
public abstract class BaseException extends RuntimeException{

	private Object errCode;

	/**
	 * 基本异常
	 *
	 * @param errMessage 异常信息
	 */
	public BaseException(Object errMessage) {
		super(ObjectUtil.objectToUFTF8String(errMessage));
	}

	/**
	 * 基本异常
	 *
	 * @param errMessage 异常信息
	 * @param errCode 异常状态
	 */
	public BaseException(Object errMessage, Object errCode) {
		super(ObjectUtil.objectToUFTF8String(errMessage));
		this.errCode = errCode;
	}

	/**
	 * 基本异常
	 *
	 * @param errMessage 异常信息
	 * @param cause 原因
	 */
	public BaseException(Object errMessage, Throwable cause) {
		super(ObjectUtil.objectToUFTF8String(errMessage), cause);
	}

	/**
	 * 基本异常
	 *
	 * @param errMessage 异常信息
	 * @param cause 原因
	 * @param errCode 异常状态
	 */
	public BaseException(Object errMessage, Throwable cause, Object errCode) {
		super(ObjectUtil.objectToUFTF8String(errMessage), cause);
		this.errCode = errCode;
	}


	/**
	 * 获取异常状态
	 *
	 * @return 异常状态
	 *
	 * @since 2023-04-25
	 */
	public Object getErrCode() {
		return this.errCode;
	}

	/**
	 * 设置异常状态
	 *
	 * @param errCode 异常状态
	 *
	 * @since 2023-04-25
	 */
	public void setErrCode(Object errCode) {
		this.errCode = errCode;
	}

}
