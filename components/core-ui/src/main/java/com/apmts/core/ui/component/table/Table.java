package com.apmts.core.ui.component.table;

import java.io.IOException;

import com.apmts.core.ui.component.RenderableContainer;

public abstract class Table implements RenderableContainer{

	private String fieldName;
	
	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public abstract TableColumn[] getColumns();
	
	public abstract void renderData(TableDataRequest request) throws IOException;
	
	public ColumnRenderer[] getRenderers() {
		return new ColumnRenderer[0];
	}
}
