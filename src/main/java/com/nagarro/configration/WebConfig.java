package com.nagarro.configration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nagarro.constants.Constants;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { Constants.ROOT };
	}

}
