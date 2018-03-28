package io.glaucus.demo.model;

/**
 * Model class for response object returned by API endpoint.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
public class ApiResponse {

	/**
     * Code value of success(0)/error(-1)
     */
	private int code;
	
	/**
     * Error/success message string
     */	
	private String message;

	public ApiResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
