package com.angle.model;

import com.angle.utils.StringUtils;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * @author Lucifer
 * 
 */
public class ErrorStatus  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 错误消息KEY
	 */
	// 200
	public static final String KEY_SUCCESS = "02000000";
	// 401
	public static final String KEY_UNAUTHORIZED = "04010000";
	// 403
	public static final String KEY_FORBIDDEN = "04030000";
	public static final String KEY_CONTENT_TOO_LARGE = "04030001";

	// 404
	public static final String KEY_NOT_FOUND = "04040000";
	public static final String KEY_METHOD_NOT_EXISTS_1 = "04040001";

	// 412
	public static final String KEY_PRECONDITION_FAILED = "04120000";
	public static final String KEY_REQUIRED_ARGUMENT_MISSING_1 = "04120001";
	public static final String KEY_INVALID_ARGUMENT_2 = "04120002";
	public static final String KEY_INVALID_ARGUMENT_1 = "04120003";

	// 429
	public static final String KEY_TOO_MANY_REQUESTS = "04290000";
	// 500
	public static final String KEY_INTERNAL_SERVER_ERROR = "05000000";

	// 1100
	public static final String KEY_DUPLICATED_ARGUMENT_1 = "11000000";
	public static final String KEY_DUPLICATED_EMAIL = "11000001";
	public static final String KEY_DUPLICATED_PHONE = "11000002";
	public static final String KEY_DUPLICATED_NICKNAME = "11000003";
	public static final String KEY_UNREGISTERED_ARGUMENT_1 = "11000004";
	public static final String KEY_INVALID_CREDENTIALS = "12000000";
	public static final String KEY_INVALID_VERIFICATION_CODE = "12000001";

	/**
	 * 资源束名称
	 */
	private static final String RESOURCE_BUNDLE_NAME = "error_message";

	// NOTE: 国际化可以在配置文件中设定。
	private final static Locale locate = new Locale("zh", "CN");
	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle(RESOURCE_BUNDLE_NAME, locate);

	/**
	 * 根据指定的错误消息KEY获取错误状态对象
	 * 
	 * @param key
	 *            错误消息KEY
	 * @param args
	 *            可选的附加格式化参数
	 * @return 错误状态对象
	 */
	public static ErrorStatus getErrorStatus(String key, Object... args) {
		return new ErrorStatus(getErrorCode(key), getErrorText(key, args));
	}

	/**
	 * 获取字符串资源
	 * 
	 * @param key
	 *            错误消息KEY
	 * @param args
	 *            可变格式化参数
	 * @return 资源值字符串
	 */
	public static String getErrorText(String key, Object... args) {
		// 从资源文件获取错误字符串.
		String value = resourceBundle.getString(key);
		if (StringUtils.nullOrEmpty(value))
			value = "N/A";

		// 替换格式化参数
		for (int i = 0; i < args.length; i++) {
			Object arg = args[i];
			value = value.replace("{" + i + "}",
					arg == null ? "(null)" : arg.toString());
		}
		return value;
	}

	/**
	 * 获取错误号
	 * 
	 * @param key
	 *            错误消息KEY
	 * @return 错误号
	 */
	public static int getErrorCode(String key) {
		return StringUtils.getInt(key, 500) / 10000;
	}

	//
	//
	//
	private int errorCode = -1;
	private String errorText = "";

	public ErrorStatus() {
		super();
		this.errorCode = getErrorCode(ErrorStatus.KEY_SUCCESS);
		this.errorText = getErrorText(ErrorStatus.KEY_SUCCESS);
	}

	public ErrorStatus(int errorCode, String errorText) {
		this.errorCode = errorCode;
		this.errorText = errorText;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorText() {
		return errorText;
	}
}
