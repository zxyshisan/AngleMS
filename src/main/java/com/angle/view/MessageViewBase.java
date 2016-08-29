package com.angle.view;


import com.angle.model.ErrorStatus;

/**
 * @author Lucifer
 * 
 */
public abstract class MessageViewBase<T> {

	private ErrorStatus status = ErrorStatus
			.getErrorStatus(ErrorStatus.KEY_SUCCESS);
	private T body = null;

	public MessageViewBase() {
		super();
	}

	public ErrorStatus getStatus() {
		return status;
	}

	public void setStatus(ErrorStatus status) {
		this.status = status;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
}
