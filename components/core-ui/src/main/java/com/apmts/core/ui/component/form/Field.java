package com.apmts.core.ui.component.form;

import com.apmts.core.ui.component.Component;
import com.apmts.core.ui.component.RenderableContainer;

public class Field extends Component {
	
	static final String NAME="name";
	static final String WIDTH="width";
	static final String LABLE="fieldLabel";

	public Field(String javascriptClass, String fieldName) {
		super(javascriptClass, fieldName);
		setRequestParamName(fieldName);
	}

	public Field(String javascriptClass, String fieldName, String label) {
		super(javascriptClass, fieldName);
		setRequestParamName(fieldName);
		setLabel(label);
	}

	

	public void setRequestParamName(String value) {
		setValue(NAME, value);
	}

	public void setLabel(String value) {
		setValue(LABLE, value);
	}

	public void setWidth(int width) {
		setValue(WIDTH, Integer.valueOf(width));
	}

	@Override
	public String renderAddToContainer(RenderableContainer form) {
		return form.getFieldName() + ".add(" + LABLE + ");\n";
	}
}
