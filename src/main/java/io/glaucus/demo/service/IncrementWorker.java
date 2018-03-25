package io.glaucus.demo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import io.glaucus.demo.model.IncrementEntity;

/**
 * This is a thread worker class that
 * updates the counter value in the DB.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
public class IncrementWorker implements Runnable {

	private SessionFactory sessionFactory;
	private int maxOpenSessions;

	public IncrementWorker(SessionFactory sessionFactory, int maxOpenSessions) {
		this.sessionFactory = sessionFactory;
		this.maxOpenSessions = maxOpenSessions;
	}

	public void run() {

		synchronized (sessionFactory) {
			while (sessionFactory.getStatistics().getSessionOpenCount() >= maxOpenSessions) {
				try {
					sessionFactory.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			IncrementEntity currentIe = (IncrementEntity) session.createCriteria(IncrementEntity.class).uniqueResult();
			Integer currentValue = currentIe.getValue() + 1;
			currentIe.setValue(currentValue);
			session.update(currentIe);
			tx.commit();
			session.close();
			sessionFactory.notify();
		}

	}
}
