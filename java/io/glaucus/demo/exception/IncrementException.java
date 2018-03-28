package io.glaucus.demo.exception;

/**
 * This class provides the custom Exception implementation
 * thrown when an increment operation fails.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
@SuppressWarnings("serial")
public class IncrementException extends Exception {

	private int errorCode;

	public IncrementException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
