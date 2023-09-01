package com.example.jesper.repository;

import com.example.jesper.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Employee JPA repository
 *
 * @author Md. Alamin Hossain
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
