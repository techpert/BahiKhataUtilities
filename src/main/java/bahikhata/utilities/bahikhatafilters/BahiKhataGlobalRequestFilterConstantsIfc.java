/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.bahikhatafilters;

import java.util.ArrayList;

/**
 * @author Vrinda
 *
 */
public interface BahiKhataGlobalRequestFilterConstantsIfc {

	public static final String USER_ENDPOINT_PRINCIPLE_PATH = "user";
	public static final String USER_ENDPOINT_CREATE_PATH = "/create";
	public static final String USER_ENDPOINT_LOGIN_PATH = "/login";
	public static final ArrayList<String> PATHS_TO_IGNORE_AUTHENTICATION = new ArrayList<String>() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		{
			add("/".concat(USER_ENDPOINT_PRINCIPLE_PATH.concat(USER_ENDPOINT_CREATE_PATH).concat("/")));
			add("/".concat(USER_ENDPOINT_PRINCIPLE_PATH.concat(USER_ENDPOINT_LOGIN_PATH).concat("/")));
			// etc
		}
	};

	public static final String AUTHENTICATION_HEADER = "Authentication";

	public static final String AUTH_FAILED_PROPERTY = "auth-failed";
	public static final String AUTH_NOT_REQUIRED_PROPERTY = "auth-not-required";

	public static final String SESSION_EXPIRED_RESPONSE_MESSAGE = " Session expired please login again with your credentials to obtain a new token";
	public static final String TAMPERED_AUTHENTICATION_TOKEN_RESPONSE_MESSAGE = " Authentication token has been tampered with.!!!!!!!!!!";
	public static final String MISSING_AUTHENTICATION_TOKEN_RESPONSE_MESSAGE = " No Authentication Header found in request";
	public static final String UNSUPPORTED_MEDIA_TYPE = " Unsupported media type sent in request";

}
