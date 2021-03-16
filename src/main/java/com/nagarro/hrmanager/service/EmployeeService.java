package com.nagarro.hrmanager.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constants.Constants;
import com.nagarro.hrmanager.models.Employee;

@Service
public class EmployeeService {

	/**
	 * This function provides list of all the employees from URL that returns the
	 * list of employees from database
	 * 
	 * @return List<Employee>
	 */
	public List<Employee> getEmployees() {
		final String url = Constants.LIST_URL;
		final RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		final List<Employee> employees = responseEntity.getBody();
		return employees;
	}

	/**
	 * This function provides employee from URL that returns the employee from
	 * database
	 * 
	 * @param emp_code
	 * @return Employee
	 */
	public Employee getEmployee(final Long emp_code) {
		final String url = Constants.GET_URL + emp_code;
		final RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, Employee.class);
	}

	/**
	 * This function add employee provided by the HR Manager to the database using
	 * URL
	 * 
	 * @param employee
	 */
	public void addEmployee(final Employee employee) {
		final String url = Constants.UPLOAD_URL;
		final RestTemplate restTemplate = new RestTemplate();
		final HttpEntity<Employee> entity = new HttpEntity<Employee>(employee);
		restTemplate.postForObject(url, entity, Employee.class);
	}

	/**
	 * This function deletes employee using URL that returns the employee from
	 * database
	 * 
	 * @param emp_code
	 */
	public void deleteEmployee(final Long emp_code) {
		final String url = Constants.DELETE_URL + emp_code;
		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}

	/**
	 * This function updates employee using URL that updates the employee to
	 * database
	 * 
	 * @param employee
	 * @param emp_code
	 */
	public void updateEmployee(final Employee employee, final Long emp_code) {
		final String url = Constants.UPDATE_URL + emp_code;
		final RestTemplate restTemplate = new RestTemplate();
		final HttpEntity<Employee> entity = new HttpEntity<Employee>(employee);
		restTemplate.put(url, entity, emp_code);
	}

}
