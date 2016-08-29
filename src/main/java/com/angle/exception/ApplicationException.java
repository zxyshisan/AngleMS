package com.angle.exception;


import com.angle.model.ErrorStatus;

/**
 * 应用程序异常
 * <ul>
 * 包括错误号, 错误消息
 * </ul>
 * 
 * @author Lucifer
 * 
 */
public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorStatus errorStatus;

	/**
	 * 初始化新的应用程序异常实例为内部服务器错误(500).
	 */
	public ApplicationException() {
		this(ErrorStatus.KEY_INTERNAL_SERVER_ERROR);
	}

	public ApplicationException(ErrorStatus errorStatus) {
		this.errorStatus = errorStatus;
	}

	/**
	 * 初始化新的应用程序异常实例为指定的错误类型.
	 * 
	 * @param key
	 *            错误消息KEY
	 * @param args
	 *            格式化消息参数
	 * @see ErrorStatus
	 */
	public ApplicationException(String key, Object... args) {
		errorStatus = ErrorStatus.getErrorStatus(key, args);
	}

	@Override
	public String getMessage() {
		return errorStatus.getErrorText();
	}

	/**
	 * 获取错误号
	 * 
	 * @return
	 */
	public int getErrorCode() {
		return errorStatus.getErrorCode();
	}

	public ErrorStatus getErrorStatus() {
		return errorStatus;
	}
}
