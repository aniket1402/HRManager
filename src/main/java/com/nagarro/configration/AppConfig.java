package com.nagarro.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.hrmanager.dao.HRManagerDao;
import com.nagarro.hrmanager.daoImpl.HRManagerDaoImpl;
import com.nagarro.hrmanager.service.AuthService;
import com.nagarro.hrmanager.service.EmployeeService;

/**
 * This class contains all the beans
 * 
 * @author Aniket Gupta
 *
 */
@Configuration
public class AppConfig {

	@Bean
	public EmployeeService getEmployeeService() {
		return new EmployeeService();
	}

	@Bean
	public HRManagerDao getHRManager() {
		return new HRManagerDaoImpl();
	}

	@Bean
	public AuthService getAuthService() {
		return new AuthService();
	}

}
