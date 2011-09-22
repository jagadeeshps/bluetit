package com.apmts.core.ui.component.table;

import com.apmts.core.ui.component.Renderable;
import com.apmts.core.ui.component.RenderableContainer;


public class HeaderFooterPanel implements Renderable {

	String name;
	boolean header;

	Renderable renderable;
	
	public HeaderFooterPanel(boolean header) {
		this.header = header;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVariableName() {
		return name + "_grid_" + (header ? "header" : "footer");
	}
	
	public void setRenderable(Renderable renderable) {
		this.renderable = renderable;
	}
	
	public Renderable getRenderable() {
		return renderable;
	}

	public String renderComponent() {
		throw new RuntimeException("Programming error!");
	}

	public String renderAddToContainer(RenderableContainer form) {
		setName(form.getFieldName());
		return getVariableName() + " = " + form.getFieldName() + ".getView()"
				+ (header ? ".getHeaderPanel(true)" : ".getFooterPanel(true)");
	}

	
	
}
