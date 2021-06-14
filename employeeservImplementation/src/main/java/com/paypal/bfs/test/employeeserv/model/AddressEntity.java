package com.paypal.bfs.test.employeeserv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
public class AddressEntity {
	
	@Id
	@GeneratedValue
	int id;
	
	@Column
	@NotNull
	String line1;
	
	@Column
	String line2;
	
	@Column
	@NotNull
	String city;
	
	@Column
	@NotNull
	String state;
	
	@Column
	@NotNull
	String country;
	
	
	@Column
	@NotNull
	String zip_code;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLine1() {
		return line1;
	}


	public void setLine1(String line1) {
		this.line1 = line1;
	}


	public String getLine2() {
		return line2;
	}


	public void setLine2(String line2) {
		this.line2 = line2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getZip_code() {
		return zip_code;
	}


	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	
	

}
