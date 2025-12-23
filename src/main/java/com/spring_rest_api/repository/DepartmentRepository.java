package com.spring_rest_api.repository;

import com.spring_rest_api.entities.Department;
import com.spring_rest_api.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
