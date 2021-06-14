package com.paypal.bfs.test.employeeserv.model;

import java.util.UUID;

import javax.persistence.Entity;
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
public class EmployeeCreateEntity {
	
	@Id
	UUID employKey;
	
	@OneToOne
	@NotNull
	EmployeeEntity employee;
	
	public EmployeeCreateEntity() {}
	
	public EmployeeCreateEntity(UUID employeeKey, EmployeeEntity employeeEntity) {
		this.employee = employeeEntity;
		this.employKey = employeeKey;
	}

	public UUID getEmployKey() {
		return employKey;
	}

	public void setEmployKey(UUID employKey) {
		this.employKey = employKey;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
}
