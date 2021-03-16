package com.nagarro.hrmanager.dao;

import com.nagarro.hrmanager.models.HRManager;

/**
 * This class provides functionality to get HR Manager which exists in the database
 *
 */
public interface HRManagerDao {

	public HRManager getHRManager(String userId);

}
