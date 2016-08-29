package com.angle.view;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 默认返回消息
 * 
 * @author Lucifer
 * 
 */

public class DefaultMessage extends MessageViewBase<DefaultMessage.Body> {
	@JsonSerialize
	public class Body {
	}

	public DefaultMessage() {
		super();
		setBody(new Body());
	}
}
