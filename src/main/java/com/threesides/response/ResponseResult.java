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

	/**
	 * 成功
	 *
	 * @return 成功信息
	 * @param <T> T
	 *
	 * @since 2023-05-10
	 */
	public static <T> ResponseResult<T> success() {

		return success(null);
	}

	/**
	 * 成功
	 *
	 * @param data data
	 * @return 成功信息
	 * @param <T> T
	 *
	 * @since 2023-05-10
	 */
	public static <T> ResponseResult<T> success(T data) {
		return success(data, ResponseResultCodeEnum.SUCCESS);
	}

	/**
	 * 成功
	 *
	 * @param data data
	 * @param codeEnum codeEnum
	 * @return 成功信息
	 * @param <T> T
	 *
	 * @since 2023-05-10
	 */
	public static <T> ResponseResult<T> success(T data, BeanEnum codeEnum) {
		return success(data,codeEnum.getKey(),codeEnum.getValue());
	}

	/**
	 * 成功
	 *
	 * @param data data
	 * @param statusCode 状态
	 * @param message 消息
	 * @return 成功信息
	 * @param <T> T
	 *
	 * @since 2023-05-10
	 */
	public static <T> ResponseResult<T> success(T data, Object statusCode,Object message) {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setData(data);
		result.setSuccess(true);
		result.setStatusCode(statusCode);
		result.setMessage(message);
		return result;
	}

	/**
	 * 失败
	 *
	 * @return 失败信息
	 * @param <T> T
	 *
	 * @since 2023-05-11
	 */
	public static <T> ResponseResult<T> fail() {
		return fail(ResponseResultCodeEnum.SYSTEM_ERROR);
	}

	/**
	 * 失败
	 *
	 * @param codeEnum codeEnum
	 * @return 失败信息
	 * @param <T> T
	 *
	 * @since 2023-05-11
	 */
	public static <T> ResponseResult<T> fail(BeanEnum codeEnum) {
		return fail(null, codeEnum);
	}

	/**
	 * 失败
	 *
	 * @param data data
	 * @param codeEnum codeEnum
	 * @return 失败信息
	 * @param <T> T
	 *
	 * @since 2023-05-11
	 */
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
