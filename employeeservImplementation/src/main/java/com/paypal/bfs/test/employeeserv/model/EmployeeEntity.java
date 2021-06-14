package com.paypal.bfs.test.employeeserv.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EmployeeEntity {

	@Id
	@GeneratedValue
	private int empId;
	
	@Column
	@NotNull
	private String firstName;
	
	@Column
	@NotNull
	private String lastName;
	
	@Column
	@NotNull
	private Date dob;
	
	@OneToOne
	@NotNull
	private AddressEntity address;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", address=" + address + "]";
	}
	
	
}
