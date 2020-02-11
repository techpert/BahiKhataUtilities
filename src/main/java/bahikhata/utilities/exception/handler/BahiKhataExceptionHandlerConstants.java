/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.exception.handler;

/**
 * Techpert:Bahikhata : 0.0.1 :This class contains constants for
 * {@link BahiKhataExceptionHandler} class
 * 
 * @author Namit.Jain
 * @since 14-Sep-2019
 * @version 0.0.1
 */
public final class BahiKhataExceptionHandlerConstants {

	private BahiKhataExceptionHandlerConstants() {
		throw new UnsupportedOperationException(BahiKhataExceptionHandlerConstants.class.getName());
	}

	/*
	 * Techpert:Bahikhata : 0.0.1 :BahiKhata Response Constants
	 */
	public static final String BAHIKHATA_ERROR_KEY = "errors";

	public static final String BAHIKHATA_NOT_SYNTACTICALLY_VALID_RESPONSE_MESSAGE = " is not syntactically valid";

	public static final String BAHIKHATA_INVALID_DATA_TYPE = "INVALID_DATATYPE";
	public static final String BAHIKHATA_CONSTRAINT_VIOLATED = "CONSTRAINT_VIOLATED";
	public static final String BAHIKHATA_MISSING_PARAMETER = "MISSING_PARAMETER";
	public static final String BAHIKHATA_VALIDATION_ERROR = "VALIDATION_ERROR";
	public static final String BAHIKHATA_SYNTACTICALLY_INVALID = "SYNTACTICALLY_INVALID";
	public static final String BAHIKHATA_SYNTACTICALLY_INVALID_JSON = "INVALID_JSON";

	public static final String BAHIKHATA_UNSUPPORTED_CONTENT_TYPE_RESPONSE_KEY = "UNSUPPORTED_CONTENTTYPE";

	public static final String BAHIKHATA_MISSING_REQUEST_BODY_RESPONSE_MESSAGE = "Request body is missing. Please try again!";

	public static final String BAHIKHATA_REQUEST_BODY_EXCEPTION_RESPONSE_KEY = "Request body exception";

	public static final String BAHIKHATA_INVALID_REQUEST_BODY_RESPONSE_KEY = "Request body is invalid. Please try again!";


	public static final String BAHIKHATA_INTERNAL_SERVER_ERROR_KEY = "Internal Server Error";

	public static final String BAHIKHATA_INTERNAL_SERVER_ERROR_VALUE = "Service Temporarily Down. Please Try Again In Some Time.";
}
