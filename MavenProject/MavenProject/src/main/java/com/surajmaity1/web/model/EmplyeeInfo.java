package com.surajmaity1.web.model;

public class EmplyeeInfo {
	private int id;
	private String name;
	private String project;
	@Override
	public String toString() {
		return "EmplyeeInfo [id=" + id + ", name=" + name + ", project=" + project + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
}
