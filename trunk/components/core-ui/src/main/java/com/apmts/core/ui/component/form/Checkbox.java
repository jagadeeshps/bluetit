package com.apmts.core.ui.component.form;

import com.apmts.core.ui.component.Constants;

public class Checkbox extends Field {

	public Checkbox(String fieldName) {
		super(Constants.CHECKBOX_FIELD_CLASS, fieldName);
	}

	public Checkbox(String fieldName, String label) {
		super(Constants.CHECKBOX_FIELD_CLASS, fieldName, label);
	}

}
