package com.paypal.bfs.test.employeeserv.impl;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.annotations.VisibleForTesting;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.AddressRepository;
import com.paypal.bfs.test.employeeserv.dao.EmployeeCreateEntityRepository;
import com.paypal.bfs.test.employeeserv.dao.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeCreateEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.validation.EmployeeValidation;

/**
 * Implementation class for employee resource.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeResourceImplTest{

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	EmployeeValidation employeeValidation;

	@Autowired
	EmployeeCreateEntityRepository employeeHistory;

	@Test
	public void employeeGetByIdTest() {
	}

	@Test
	public void createTest() {
	}

	@Test
	public void copyEmployeeToEntityTest() {
	}

	@Test
	public void copyEntityToEmployee(EmployeeEntity entity, Employee emp) {
	}
}
