package com.nagarro.hrmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.constants.Constants;
import com.nagarro.hrmanager.models.Employee;
import com.nagarro.hrmanager.service.AuthService;
import com.nagarro.hrmanager.service.EmployeeService;

/**
 * This class is the controller for sign in and sign out for HR Managar
 *
 */
@Controller
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(Constants.SIGN_IN)
	public ModelAndView signIn(@RequestParam(Constants.USER_ID) final String userId,
			@RequestParam(Constants.PASSWORD) final String password) {
		final ModelAndView mv = new ModelAndView();
		if (!authService.validateHRManager(userId, password)) {
			mv.setViewName(Constants.INDEX_VIEW);
			return mv;
		}
		final List<Employee> employees = employeeService.getEmployees();
		mv.addObject(Constants.EMPLOYEES, employees);
		mv.addObject(Constants.USER_ID, userId);
		mv.setViewName(Constants.HOME_VIEW);
		return mv;
	}

	@RequestMapping(Constants.SIGN_OUT)
	public ModelAndView signOut() {
		final ModelAndView mv = new ModelAndView();
		mv.addObject(Constants.USER_ID, null);
		mv.setViewName(Constants.INDEX_VIEW);
		return mv;
	}

}
