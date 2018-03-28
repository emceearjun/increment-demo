package io.glaucus.demo.service;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import io.glaucus.demo.model.IncrementEntity;

/**
 * This is a thread worker class that updates the counter value in the DB.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
public class IncrementWorker implements Runnable {

	private SessionFactory sessionFactory;

	public IncrementWorker(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void run() {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			IncrementEntity currentIe = session.get(IncrementEntity.class, 0, LockMode.UPGRADE_NOWAIT);
			Integer currentValue = currentIe.getValue() + 1;
			currentIe.setValue(currentValue);
			session.update(currentIe);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
