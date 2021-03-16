package com.nagarro.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.hrmanager.dao.HRManagerDao;
import com.nagarro.hrmanager.daoImpl.HRManagerDaoImpl;

/**
 * This class contains all the beans
 * 
 * @author Aniket Gupta
 *
 */
@Configuration
public class AppConfigHR {

	@Bean
	public HRManagerDao getHRManager() {
		return new HRManagerDaoImpl();
	}
	
}

