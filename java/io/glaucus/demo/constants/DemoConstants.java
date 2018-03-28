package io.glaucus.demo.constants;

/**
 * This class contains all the static constants for error/success codes and
 * messages that will be returned by the API.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
public class DemoConstants {

	/**
	 * This nested class contains all the response codes.
	 * 
	 * @author Arjun M.C.
	 * @version 1.0
	 * @since 2018-03-25
	 */
	public class Code {

		public static final int SUCCESS = 0;
		public static final int ERROR = -1;

	}

	/**
	 * This nested class contains all the response messages.
	 * 
	 * @author Arjun M.C.
	 * @version 1.0
	 * @since 2018-03-25
	 */
	public class Message {

		public static final String UNABLE_TO_INC = "Unable to increment";
		public static final String SUCCESS_MSG = "Incremented successfully";
		public static final String TABLE_EMPTY = "Number table is empty";
		public static final String THREAD_INTERRUPT = "Increment thread interrupted";

	}

}
