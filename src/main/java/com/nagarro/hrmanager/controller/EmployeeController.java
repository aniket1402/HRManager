package com.nagarro.hrmanager.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.constants.Constants;
import com.nagarro.hrmanager.models.Employee;
import com.nagarro.hrmanager.service.EmployeeService;

/**
 * This class is the controller which provides CRUD operations on Employees
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * This function edits the details of existing employee
	 * @param userId
	 * @param emp_code
	 * @return ModelAndView
	 */
	@RequestMapping(Constants.EDIT)
	private ModelAndView editEmployee(@RequestParam(Constants.USER_ID) final String userId,
			@RequestParam(Constants.EMP_CODE) final Long emp_code) {
		final ModelAndView mv = new ModelAndView();
		final Employee employee = employeeService.getEmployee(emp_code);
		mv.addObject(Constants.EMPLOYEE, employee);
		mv.addObject(Constants.USER_ID, userId);
		mv.setViewName(Constants.EDIT_VIEW);
		return mv;
	}

	/**
	 * This function uploads new Employee
	 * @param userId
	 * @param emp_name
	 * @param loc
	 * @param email
	 * @param dob
	 * @return ModelAndView
	 */
	@RequestMapping(Constants.UPLOAD)
	private ModelAndView uploadEmployee(@RequestParam(Constants.USER_ID) final String userId,
			@RequestParam(Constants.EMP_NAME) final String emp_name, @RequestParam(Constants.LOC) final String loc,
			@RequestParam(Constants.EMAIL) final String email, @RequestParam(Constants.DOB) final String dob) {
		final ModelAndView mv = new ModelAndView();
		final Employee employee = new Employee();
		employee.setEmp_name(emp_name);
		employee.setLoc(loc);
		employee.setEmail(email);
		employee.setDob(dob);
		employeeService.addEmployee(employee);
		final List<Employee> employees = employeeService.getEmployees();
		mv.addObject(Constants.EMPLOYEES, employees);
		mv.addObject(Constants.USER_ID, userId);
		mv.setViewName(Constants.HOME_VIEW);
		return mv;
	}

	/**
	 * This function deletes existing employee
	 * @param userId
	 * @param emp_code
	 * @return ModelAndView
	 */
	@RequestMapping(Constants.DELETE)
	private ModelAndView deleteEmployee(@RequestParam(Constants.USER_ID) final String userId,
			@RequestParam(Constants.EMP_CODE) final Long emp_code) {
		final ModelAndView mv = new ModelAndView();
		employeeService.deleteEmployee(emp_code);
		final List<Employee> employees = employeeService.getEmployees();
		mv.addObject(Constants.EMPLOYEES, employees);
		mv.addObject(Constants.USER_ID, userId);
		mv.setViewName(Constants.HOME_VIEW);
		return mv;
	}

	/**
	 * This function updates existing employee details
	 * @param userId
	 * @param emp_code
	 * @param emp_name
	 * @param loc
	 * @param email
	 * @param dob
	 * @return ModelAndView
	 */
	@RequestMapping(Constants.UPDATE)
	private ModelAndView updateEmployee(@RequestParam(Constants.USER_ID) final String userId,
			@RequestParam(Constants.EMP_CODE) final Long emp_code,
			@RequestParam(Constants.EMP_NAME) final String emp_name, @RequestParam(Constants.LOC) final String loc,
			@RequestParam(Constants.EMAIL) final String email, @RequestParam(Constants.DOB) final String dob) {
		final ModelAndView mv = new ModelAndView();
		final Employee employee = new Employee();
		employee.setEmp_code(emp_code);
		employee.setEmp_name(emp_name);
		employee.setLoc(loc);
		employee.setEmail(email);
		employee.setDob(dob);
		employeeService.updateEmployee(employee, emp_code);
		final List<Employee> employees = employeeService.getEmployees();
		mv.addObject(Constants.EMPLOYEES, employees);
		mv.addObject(Constants.USER_ID, userId);
		mv.setViewName(Constants.HOME_VIEW);
		return mv;
	}

	/**
	 * This function downloads all the employees details in a CSV file
	 * @param request
	 * @param response
	 */
	@RequestMapping(Constants.DOWNLOAD)
	public void downloadEmployeeData(final HttpServletRequest request, final HttpServletResponse response) {
		final List<Employee> employees = employeeService.getEmployees();
		response.setContentType(Constants.FILE_TYPE);
		final DateFormat dateFormatter = new SimpleDateFormat(Constants.DATE_FORMAT);
		final String currentDateTime = dateFormatter.format(new Date());

		final String headerKey = Constants.CONTENT_DISP;
		final String headerValue = Constants.ATTACHMENT + currentDateTime + Constants.CSV;
		response.setHeader(headerKey, headerValue);

		ICsvBeanWriter csvWriter;
		final String[] csvHeader = { Constants.EMPLOYEE_CODE, Constants.EMPLOYEE_NAME, Constants.EMPLOYEE_LOC,
				Constants.EMPLOYEE_EMAIL, Constants.EMPLOYEE_DOB };
		final String[] nameMapping = { Constants.EMP_CODE, Constants.EMP_NAME, Constants.LOC, Constants.EMAIL,
				Constants.DOB };
		try {
			csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
			csvWriter.writeHeader(csvHeader);
			for (final Employee employee : employees) {
				csvWriter.write(employee, nameMapping);
			}

			csvWriter.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
