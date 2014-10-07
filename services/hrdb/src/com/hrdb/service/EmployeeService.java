package com.hrdb.service;
// Generated 7 Oct, 2014 3:41:50 PM


import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hrdb.*;
/**
 * Service object for domain model class Employee.
 * @see com.hrdb.Employee
 */

public interface EmployeeService {

   /**
	 * Creates a new employee.
	 * 
	 * @param created
	 *            The information of the created employee.
	 * @return The created employee.
	 */
	public Employee create(Employee created);

	/**
	 * Deletes a employee.
	 * 
	 * @param employeeId
	 *            The id of the deleted employee.
	 * @return The deleted employee.
	 * @throws EntityNotFoundException
	 *             if no employee is found with the given id.
	 */
	public Employee delete(Integer employeeId) throws EntityNotFoundException;

	/**
	 * Finds all employees.
	 * 
	 * @return A list of employees.
	 */
	public Page<Employee> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Employee> findAll(Pageable pageable);
	
	/**
	 * Finds employee by id.
	 * 
	 * @param id
	 *            The id of the wanted employee.
	 * @return The found employee. If no employee is found, this method returns
	 *         null.
	 */
	public Employee findById(Integer id) throws EntityNotFoundException;

	/**
	 * Updates the information of a employee.
	 * 
	 * @param updated
	 *            The information of the updated employee.
	 * @return The updated employee.
	 * @throws EntityNotFoundException
	 *             if no employee is found with given id.
	 */
	public Employee update(Employee updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the employees in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the employee.
	 */

	public long countAll();

}

