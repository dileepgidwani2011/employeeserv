package com.paypal.bfs.test.employeeserv.impl;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	EmployeeValidation employeeValidation;

	@Autowired
	EmployeeCreateEntityRepository employeeHistory;

	@Override
	public ResponseEntity<Employee> employeeGetById(String id) {

		Employee employee = new Employee();
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(Integer.valueOf(id));
		if (!employeeEntity.isPresent())
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

		copyEntityToEmployee(employeeEntity.get(), employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> create(Employee employee, UUID employeeKey) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		try {
			if (employeeKey == null || !employeeValidation.isValid(employee))
				return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);

			Optional<EmployeeCreateEntity> employeeRecord = employeeHistory.findById(employeeKey);
			if (employeeHistory != null && employeeRecord.isPresent())
				return new ResponseEntity<Integer>(HttpStatus.NOT_MODIFIED);
			
			copyEmployeeToEntity(employee, employeeEntity);
			employeeRepository.save(employeeEntity);
			employeeHistory.save(new EmployeeCreateEntity(employeeKey, employeeEntity));
			return new ResponseEntity<Integer>(employeeEntity.getEmpId(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public void copyEmployeeToEntity(Employee emp, EmployeeEntity entity) {
		entity.setFirstName(emp.getFirstName());
		entity.setLastName(emp.getLastName());
		entity.setDob(Date.valueOf(emp.getDob()));
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setLine1(emp.getAddress().getLine1());
		addressEntity.setLine2(emp.getAddress().getLine2());
		addressEntity.setCity(emp.getAddress().getCity());
		addressEntity.setState(emp.getAddress().getState());
		addressEntity.setCountry(emp.getAddress().getCountry());
		addressEntity.setZip_code(emp.getAddress().getZipCode());
		addressRepository.save(addressEntity);
		entity.setAddress(addressEntity);
	}

	public void copyEntityToEmployee(EmployeeEntity entity, Employee emp) {
		emp.setFirstName(entity.getFirstName());
		emp.setLastName(entity.getLastName());
		emp.setDob(entity.getDob().toString());
		Address address = new Address();
		address.setLine1(entity.getAddress().getLine1());
		address.setLine2(entity.getAddress().getLine2());
		address.setCity(entity.getAddress().getCity());
		address.setState(entity.getAddress().getState());
		address.setCountry(entity.getAddress().getCountry());
		address.setZipCode(entity.getAddress().getZip_code());
		emp.setAddress(address);
	}
}
