package com.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


public class Address {
	
	private int addrId;
	private String location;
	private Set<Employee> emps=new HashSet<Employee>();
	

	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", location=" + location + ", emps=" + emps + "]";
	}

	
	
}
