package io.glaucus.demo.dao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import io.glaucus.demo.constants.DemoConstants;
import io.glaucus.demo.exception.IncrementException;
import io.glaucus.demo.service.IncrementWorker;

/**
 * Implementation of data access interface for
 * Increment DB operation.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
@Repository
@Transactional
public class IncrementDaoImpl implements IncrementDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Value("${thread.pool.size}")
	private int THREAD_POOL_SIZE;

	@Value("${max.open.sessions}")
	private int MAX_OPEN_SESSIONS;

	/**
	 * This method provides the concrete implementation
	 * of DB update
	 * 
	 */
	@Override
	public void increment() throws IncrementException {

		// sessionFactory.getCurrentSession().persist(ie);

		try {
			ExecutorService pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
			Runnable workerThread = new IncrementWorker(sessionFactory, MAX_OPEN_SESSIONS);
			pool.execute(workerThread);
			pool.shutdown();
		} catch (NullPointerException npe) {
			throw new IncrementException(DemoConstants.Message.TABLE_EMPTY, DemoConstants.Code.ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IncrementException(DemoConstants.Message.UNABLE_TO_INC, DemoConstants.Code.ERROR);
		}

	}

}
