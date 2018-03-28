package io.glaucus.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.glaucus.demo.model.ApiResponse;
import io.glaucus.demo.service.IncrementService;

/**
 * Controller class for API endpoint that
 * will be used to increment the DB counter value.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
@RestController
@RequestMapping("/glaucus/api/v1")
public class IncrementController {

	@Autowired
	IncrementService incrementService;

	/**
	 * This method returns the sessionFactory object
	 * 
	 * @return ApiResponse
	 */
	@RequestMapping("/increment")
	public ApiResponse increment() {

		return incrementService.increment();

	}

}
