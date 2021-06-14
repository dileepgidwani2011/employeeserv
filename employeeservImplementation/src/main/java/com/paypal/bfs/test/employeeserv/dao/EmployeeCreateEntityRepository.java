package com.paypal.bfs.test.employeeserv.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.model.EmployeeCreateEntity;

@Repository
public interface EmployeeCreateEntityRepository extends JpaRepository<EmployeeCreateEntity, UUID>{

}
