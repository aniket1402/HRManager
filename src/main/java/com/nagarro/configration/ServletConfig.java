package com.nagarro.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nagarro.constants.Constants;

/**
 * @author Aniket Gupta
 *
 */
@Configuration
@ComponentScan({ ServletConfig.FLIGHTSEARCH_CONTROLLER })
public class ServletConfig {

	static final String FLIGHTSEARCH_CONTROLLER = "com.nagarro.hrmanager.controller";

	@Bean
	public InternalResourceViewResolver viewResolver() {
		final InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setSuffix(Constants.JSP);
		return vr;
	}
}
