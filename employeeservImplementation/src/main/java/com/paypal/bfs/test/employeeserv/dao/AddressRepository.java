package com.paypal.bfs.test.employeeserv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.model.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer>{

}
