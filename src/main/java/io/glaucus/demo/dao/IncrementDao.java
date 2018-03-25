package io.glaucus.demo.dao;

import io.glaucus.demo.exception.IncrementException;

/**
 * Data access interface for Increment DB operation.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
public interface IncrementDao {

	/**
	 * This method updates the database
	 * with incremented counter value
	 * 
	 * @throws IncrementException if increment operation fails.
	 */
	void increment() throws IncrementException;

}
