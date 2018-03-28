package io.glaucus.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.glaucus.demo.constants.DemoConstants;
import io.glaucus.demo.dao.IncrementDao;
import io.glaucus.demo.exception.IncrementException;
import io.glaucus.demo.model.ApiResponse;

/**
 * Service interface that provides the implementation for
 * {@link IncrementService} interface.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
@Component
public class IncrementServiceImpl implements IncrementService {

	@Autowired
	IncrementDao incrementDao;

	/**
	 * This method calls the data access method to increment the counter value.
	 * Returns ApiResponse with the success/error code and message.
	 * 
	 * @return ApiResponse
	 */
	@Override
	public ApiResponse increment() {

		try {
			incrementDao.increment();
		} catch (IncrementException e) {
			e.printStackTrace();
			return new ApiResponse(e.getErrorCode(), e.getMessage());
		}

		return new ApiResponse(DemoConstants.Code.SUCCESS, DemoConstants.Message.SUCCESS_MSG);
	}

}
