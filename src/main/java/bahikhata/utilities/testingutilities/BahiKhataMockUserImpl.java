/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import java.lang.annotation.Annotation;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used to mock a BahiKhataUser to
 * reset security context at runtime during test execution
 * 
 * @author Rudhra Koul
 * @since 13 Oct 2019
 * @version 1.0
 */
public class BahiKhataMockUserImpl {
	String username;

	String[] authorities;

	String password;

	String[] scopes;

	String clientId;

	String clientSecret;
	private static BahiKhataMockUser bahiKhataMockUser;

	/**
	 * Techpert:Bahikhata : 0.0.1 :This constructor creates a Object of
	 * BahiKhataMockUser with no defaults
	 * 
	 * @param username
	 * @param authorities
	 * @param password
	 * @param scopes
	 * @param clientId
	 * @param clientSecret
	 */
	public BahiKhataMockUserImpl(String username,

			String authorities,

			String password,

			String scopes,

			String clientId,

			String clientSecret) {
		this.authorities = new String[] { authorities };
		this.password = password;
		this.scopes = new String[] { scopes };
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.username = username;
		BahiKhataMockUserImpl.bahiKhataMockUser = createMockUser(username, authorities, password, scopes, clientId,
				clientSecret);
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This constructor creates a Object of
	 * BahiKhataMockUser with all defaults except scopes and authorities
	 * 
	 * @param scopes
	 * @param authorities
	 */
	public BahiKhataMockUserImpl(

			String scopes,

			String authorities

	) {
		this.authorities = new String[] { authorities };
		this.password = "bahiKhataTestPassword";
		this.scopes = new String[] { scopes };
		this.clientId = "BahiKhataManagerReadTestClientId";
		this.clientSecret = "BahiKhataManagerReadTestClientSecret";
		this.username = "bahiKhataTestUser";
		BahiKhataMockUserImpl.bahiKhataMockUser = createMockUser(username, authorities, password, scopes, clientId,
				clientSecret);
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method is used to create a defult
	 * BahiKhataMockUser
	 * <p>
	 * The username attribute will get default value as
	 * <i><B>bahiKhataTestUser</i></B>
	 * </p>
	 * 
	 * <p>
	 * The password attribute with default value as
	 * <i><B>bahiKhataTestPassword</i></B>
	 * </p>
	 * 
	 * <p>
	 * The authorities attribute with default value as <i><B>SecureService</i></B>
	 * </p>
	 * 
	 * 
	 * <p>
	 * The scopes attribute with default value as <i><B>read</i></B>
	 * </p>
	 * 
	 * 
	 * <p>
	 * The clientId attribute with default value as
	 * <i><B>BahiKhataManagerReadTestClientId</i></B>
	 * </p>
	 * 
	 * <p>
	 * The clientSecret attribute with default value as
	 * <i><B>BahiKhataManagerReadTestClientSecret</i></B>
	 * </p>
	 * 
	 * @author Rudhra Koul
	 * @since 14 Oct 2019
	 * @version 1.0
	 */
	public static void createDefaultBahiKhataMockUser() {
		BahiKhataMockUserImpl.bahiKhataMockUser = createMockUser("bahiKhataTestUser", "SecureService",
				"bahiKhataTestPassword", "read", "BahiKhataManagerReadTestClientId",
				"BahiKhataManagerReadTestClientSecret");
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This constructor creates a null valued
	 * {@link BahiKhataMockUser } which results in clearing out the security context
	 */
	public BahiKhataMockUserImpl() {
		BahiKhataMockUserImpl.bahiKhataMockUser = null;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :his Method is used to create an Object of
	 * BahiKhataMockUser
	 * 
	 * @author Rudhra Koul
	 * @since 14 Oct 2019
	 * @version 1.0
	 * @param username
	 * @param authorities
	 * @param password
	 * @param scopes
	 * @param clientId
	 * @param clientSecret
	 * @return BahiKhataMockUser
	 */
	private static BahiKhataMockUser createMockUser(String username,

			String authorities,

			String password,

			String scopes,

			String clientId,

			String clientSecret) {

		return new BahiKhataMockUser() {

			@Override
			public Class<? extends Annotation> annotationType() {

				return null;
			}

			@Override
			public String username() {

				return username;
			}

			@Override
			public String[] scopes() {

				return new String[] { scopes };
			}

			@Override
			public String password() {

				return password;
			}

			@Override
			public String clientSecret() {

				return clientSecret;
			}

			@Override
			public String clientId() {

				return clientId;
			}

			@Override
			public String[] authorities() {

				return new String[] { authorities };
			}
		};

	}

	/**
	 * @return the bahiKhataMockUser
	 */
	public BahiKhataMockUser getBahiKhataMockUser() {
		return bahiKhataMockUser;
	}

}
