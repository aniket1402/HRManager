package com.nagarro.hrmanager.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.hrmanager.dao.HRManagerDao;
import com.nagarro.hrmanager.models.HRManager;

/**
 * This class provides the implementation of HRManagerDao
 *
 */
public class HRManagerDaoImpl implements HRManagerDao {

	Configuration config;
	SessionFactory sessionFactory;

	public HRManagerDaoImpl() {
		config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}

	@Override
	public HRManager getHRManager(final String userId) {
		final Session session = sessionFactory.openSession();
		final HRManager hrManager = session.get(HRManager.class, userId);
		return hrManager;
	}

}
