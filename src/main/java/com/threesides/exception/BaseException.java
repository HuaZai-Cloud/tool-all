package com.threesides.exception;

import com.threesides.lang.ObjectUtil;

/**
 * BaseException
 *
 * @author Di Wu
 * @since 2023-04-12
 */
public abstract class BaseException extends RuntimeException{

	private Object errCode;

	public BaseException(Object errMessage) {
		super(ObjectUtil.objectToUFTF8String(errMessage));
	}

	public BaseException(Object errMessage, Object errCode) {
		super(ObjectUtil.objectToUFTF8String(errMessage));
		this.errCode = errCode;
	}

	public BaseException(Object errMessage, Throwable cause) {
		super(ObjectUtil.objectToUFTF8String(errMessage), cause);
	}

	public BaseException(Object errMessage, Throwable cause, Object errCode) {
		super(ObjectUtil.objectToUFTF8String(errMessage), cause);
		this.errCode = errCode;
	}



	public Object getErrCode() {
		return this.errCode;
	}

	public void setErrCode(Object errCode) {
		this.errCode = errCode;
	}

}
