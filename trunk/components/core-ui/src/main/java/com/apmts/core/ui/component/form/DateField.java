package com.apmts.core.ui.component.form;

import com.apmts.core.ui.component.Constants;

public class DateField extends Field {
	static final String DATE_FORMAT = "format";

	public DateField(String fieldName) {
		super(Constants.DATE_FIELD_CLASS, fieldName);
	}

	public DateField(String fieldName, String label) {
		super(Constants.DATE_FIELD_CLASS, fieldName, label);
	}

	public void setAllowBlank(boolean flag) {
		setValue(Constants.ALLOW_BLANK, Boolean.valueOf(flag));
	}
	
	public void setFormat(String s) {
		setValue(DATE_FORMAT, s);
	}
	
}
