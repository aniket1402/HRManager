package com.nagarro.hrmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.hrmanager.dao.HRManagerDao;
import com.nagarro.hrmanager.models.HRManager;

@Service
public class AuthService {

	@Autowired
	private HRManagerDao hrManagerDao;

	/**
	 * This method returns true if HR Manager is present in the database
	 * 
	 * @param userId
	 * @param password
	 * @return boolean
	 */
	public boolean validateHRManager(final String userId, final String password) {
		final HRManager hrManager = hrManagerDao.getHRManager(userId);
		return hrManager != null && hrManager.getPassword().equals(password);
	}
}
