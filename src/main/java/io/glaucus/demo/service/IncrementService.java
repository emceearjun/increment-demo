package io.glaucus.demo.service;

import io.glaucus.demo.model.ApiResponse;

/**
 * Service interface that provides a method for
 * incrementing the database counter value.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
public interface IncrementService {

	/**
	 * This method returns the ApiResponse object
	 * with the success/error code and message.
	 * 
	 * @return ApiResponse
	 */
	ApiResponse increment();

}
