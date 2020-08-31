package com.example.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{




}
