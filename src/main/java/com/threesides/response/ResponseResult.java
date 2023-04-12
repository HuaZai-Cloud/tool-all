package com.threesides.response;


import com.threesides.beans.BeanEnum;
import com.threesides.constant.enums.ResponseResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * ResponseResult
 *
 * @author Di Wu
 * @since 2023-04-09
 */
@Data
public class  ResponseResult<T> implements Serializable {

	private static final long serialVersionUID = 7533718379713790888L;

	private T data;

	private boolean success;

	private Object statusCode;

	private Object message;

	public static <T> ResponseResult<T> success() {

		return success(null);
	}

	public static <T> ResponseResult<T> success(T data) {
		return success(data, ResponseResultCodeEnum.SUCCESS);
	}

	public static <T> ResponseResult<T> success(T data, BeanEnum codeEnum) {
		return success(data,codeEnum.getKey(),codeEnum.getValue());
	}
	public static <T> ResponseResult<T> success(T data, Object statusCode,Object message) {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setData(data);
		result.setSuccess(true);
		result.setStatusCode(statusCode);
		result.setMessage(message);
		return result;
	}
	public static <T> ResponseResult<T> fail() {
		return fail(ResponseResultCodeEnum.INTER_ERROR);
	}
	public static <T> ResponseResult<T> fail(BeanEnum codeEnum) {
		return fail(null, codeEnum);
	}

	public static <T> ResponseResult<T> fail(T data, BeanEnum codeEnum) {
		return fail(data,codeEnum.getKey(),codeEnum.getValue());
	}

	public static <T> ResponseResult<T> fail(Object statusCode,Object message) {
		return fail(null,statusCode,message);
	}

	public static <T> ResponseResult<T> fail(T data, Object statusCode,Object message) {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setData(data);
		result.setSuccess(false);
		result.setStatusCode(statusCode);
		result.setMessage(message);
		return result;
	}
}
