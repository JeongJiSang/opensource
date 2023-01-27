package com.jbground.source.database.model.base;

import java.util.Date;

public abstract class Entity {

	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String NA = "NA";

	protected String id = "";
	protected String name = "";
	protected String creator = "";
	protected String editor = "";
	protected Date createTime = new Date();
	protected Date editTime = new Date();
	protected String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Entity{");
		sb.append("id='").append(id).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", creator='").append(creator).append('\'');
		sb.append(", editor='").append(editor).append('\'');
		sb.append(", createTime=").append(createTime);
		sb.append(", editTime=").append(editTime);
		sb.append(", description='").append(description).append('\'');
		sb.append('}');
		return sb.toString();
	}
}