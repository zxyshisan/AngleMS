package com.angle.view;


import com.angle.model.ErrorStatus;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Lucifer
 * 
 */
public class ErrorMessage extends MessageViewBase<ErrorMessage.Body> {
	@JsonSerialize
	public class Body {
	}

	public ErrorMessage(ErrorStatus status) {
		super();
		setStatus(status);
		setBody(new Body());
	}
}
