package com.angle.view;

import java.util.HashMap;

public class MultiValuesMessage<T> extends
		MessageViewBase<MultiValuesMessage<T>.Body> {
	public class Body extends HashMap<String, T> {
		private static final long serialVersionUID = 1L;
	}

	public MultiValuesMessage() {
		setBody(new Body());
	}
}
