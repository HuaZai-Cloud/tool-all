package com.threesides.constant.enums;

import com.threesides.beans.BeanEnum;

/**
 * ResponseResultCodeEnum 响应枚举
 *
 * @author Di Wu
 * @since 2023-04-09
 */
public enum ResponseResultCodeEnum implements BeanEnum {


	SUCCESS(200, "操作成功"),
	SYSTEM_ERROR(500, "服务器异常，请稍后再试"),
	BUSINESS_ERROR(4000, "业务异常，请稍后再试"),



	;
	private final Integer code;

	private final String message;

	ResponseResultCodeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public Object getKey() {
		return code;
	}

	@Override
	public Object getValue() {
		return message;
	}

}
