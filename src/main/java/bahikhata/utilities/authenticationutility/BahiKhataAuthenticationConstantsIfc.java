/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.authenticationutility;

/**
 * @author Rudhra Koul This interface contains Authentication token specific
 *         constants
 *
 */
public interface BahiKhataAuthenticationConstantsIfc {

	/**
	 * Techpert:Bahikhata : 0.0.1 :Certificate Specific Constants
	 */
	public static final String SERVER_CERTIFICATE = "server.p12";
	public static final String KEYSTORE_PASSWORD = "";

	/**
	 * Techpert:Bahikhata : 0.0.1 :Claim Specific Constants
	 */
	public static final String CLAIM_USER_FIRST_NAME = "userFirstName";
	public static final String CLAIM_EXPIRATION_DATE = "expiration";

	/**
	 * Techpert:Bahikhata : 0.0.1 :Token Specific Constants
	 */
	public static final long TOKEN_EXPIRATION_OFFSET = 2;
	public static final String TOKEN_ISSED_BY = "BahiKhataWebService";
	public static final int REFRESH_TOKEN_THRESHOLD = 10;
}
