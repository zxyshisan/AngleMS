package com.angle.controller;

import javax.servlet.http.HttpServletResponse;

import com.angle.exception.ApplicationException;
import com.angle.model.ErrorStatus;
import com.angle.view.DefaultMessage;
import com.angle.view.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Lucifer
 *
 */
public class MessageControllerBase {

	protected final Logger log;
	protected final DefaultMessage DEFAULT_MESSAGE;

	public MessageControllerBase() {
		log = LoggerFactory.getLogger(this.getClass());
		DEFAULT_MESSAGE = new DefaultMessage();
	}

	/**
	 * 异常处理
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	public @ResponseBody Object handleException(Throwable ex) {
		log.warn("handling exception: {}...", ex.getClass().getName());
		ErrorMessage msg = null;
		if (ex instanceof ApplicationException) {
			ApplicationException e = (ApplicationException) ex;
			msg = new ErrorMessage(e.getErrorStatus());
			log.warn("error status: {}, {}", e.getErrorCode(), e.getMessage());
		} else if (ex instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException e = (MissingServletRequestParameterException) ex;
			ErrorStatus status = ErrorStatus.getErrorStatus(
					ErrorStatus.KEY_REQUIRED_ARGUMENT_MISSING_1,
					e.getParameterName());
			msg = new ErrorMessage(status);
			log.warn("required argument:{} missing...", e.getParameterName());
		} else {
			msg = new ErrorMessage(
					ErrorStatus
							.getErrorStatus(ErrorStatus.KEY_INTERNAL_SERVER_ERROR));
			log.warn("unexpected error: {}", ex.getMessage());
			ex.printStackTrace();
		}
		return msg;
	}

	/**
	 * 统一添加响应头信息
	 * 
	 * @param response
	 */
	@ModelAttribute
	public void setVaryResponseHeader(HttpServletResponse response) {
		log.info("Access-Control-Allow-Origin=*");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Credentials", "true");
	}
}
