package com.apmts.core.ui.component.form;

import com.apmts.core.ui.component.Constants;

public class TextField extends Field {

	public TextField(String fieldName) {
		super(Constants.TEXT_FIELD_CLASS,fieldName);
	}
	
	
	public TextField(String fieldName,String label) {
		super(Constants.TEXT_FIELD_CLASS,fieldName, label);
	}
	


}
