package com.apmts.core.ui.component.form;

import java.util.ArrayList;
import java.util.List;

import com.apmts.core.ui.component.Component;
import com.apmts.core.ui.component.Constants;
import com.apmts.core.ui.component.Renderable;
import com.apmts.core.ui.component.RenderableContainer;

public class Form extends Component implements RenderableContainer {

	static final String ALIGN_RIGHT  = "right";
	static final String LABEL_ALIGN  = "labelAlign";
	static final String LABEL_WIDTH  = "labelWidth";
	static final String BUTTON_WIDTH = "buttonAlign";
	
	
	List<Renderable> fieldList = new ArrayList<Renderable>();
	List<Renderable> initScript = new ArrayList<Renderable>();

	public Form(String fieldName) {
		super(Constants.FORM_CLASS, fieldName);
		setLabelWidth(100);
		setLabelAlign(ALIGN_RIGHT);
		setButtonAlign(ALIGN_RIGHT);
	}

	public void setLabelAlign(String string) {
		setValue(LABEL_ALIGN, string);
	}

	public void setLabelWidth(int width) {
		setValue(LABEL_WIDTH, width);
	}

	public void setButtonAlign(String string) {
		setValue(BUTTON_WIDTH, string);
	}

	public void addField(Field field) {
		fieldList.add(field);
	}

	public void addFieldSet(String fieldSetName, Field... fields) {
		FieldSet fset = new FieldSet(fieldSetName);
		for (Field f : fields) {
			fset.add(f);
		}
		fieldList.add(fset);
	}
	
	public void addInitScript(final String script) {
		initScript.add(new Renderable() {
			public String renderAddToContainer(RenderableContainer form) {
				return null;
			}
			public String renderComponent() {
				return script;
			}
		});
	}
	

	@Override
	public String renderComponent() {
		StringBuilder builder = new StringBuilder();
		builder.append(Constants.EXT_JS_ONREADY);
		builder.append(Constants.FUNCTION_OPEN);
		builder.append(Constants.JS_FUNCTION);
		builder.append(Constants.FUNCTION_BODY_BEGIN);
		
		for (Renderable r : fieldList) {
			builder.append(r.renderComponent());
		}
		
		builder.append(renderJavascriptConstructor());

		for (Renderable r : fieldList) {
			builder.append(r.renderAddToContainer(this)).append(Constants.NEW_LINE);
		}
		
		for (Renderable r : initScript) {
			builder.append(r.renderComponent()).append(Constants.NEW_LINE);
		}
		
		builder.append(Constants.FUNCTION_BODY_CLOSE);
		builder.append(Constants.FUNCTION_CLOSE);
		
		return builder.toString();
	}

	class FieldSet implements Renderable {

		String label;

		List<Field> fields = new ArrayList<Field>();

		public FieldSet(String label) {
			this.label = label;
		}

		public FieldSet add(Field field) {
			fields.add(field);
			return this;
		}

		public List<Field> getFields() {
			return fields;
		}

		public String renderComponent() {
			StringBuilder s = new StringBuilder();
			for (Field field : fields) {
				s.append(field.renderComponent());
			}
			s.append(Constants.NEW_LINE);
			return s.toString();
		}

		public String renderAddToContainer(RenderableContainer form) {
			
			String s = form.getFieldName() 
					+ ".fieldset(" 
					+ "{legend:'" 
					+ label 
					+ "'},\n";
			
			for (int i=0;i<fields.size(); i++) { 
				Field field = fields.get(i);
				if (i>0) {
					s += ",\n";
				}
				s += field.getFieldName();
			}
			s += "\n);";
			return s;
		}

	}

}
