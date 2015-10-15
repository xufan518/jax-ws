package com.rvho.server.entity;

import java.io.Serializable;

public class PersonEntity implements Serializable {
	private static final long serialVersionUID = -7211227324542440039L;
	
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}