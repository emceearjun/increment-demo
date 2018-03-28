package io.glaucus.demo;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Increment Demo Application
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
@Configuration
public class DemoConfig {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	/**
	 * This method returns the sessionFactory object
	 * 
	 * @return SessionFactory
	 */

	@Bean
	public SessionFactory getSessionFactory() {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}
