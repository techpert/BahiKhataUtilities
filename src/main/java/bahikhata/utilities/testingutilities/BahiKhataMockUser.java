/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.test.context.support.TestExecutionEvent;
import org.springframework.security.test.context.support.WithSecurityContext;

/**
 * <p>
 * Techpert:Bahikhata : 0.0.1 :This class is used as an annotation to initialize
 * security context and generate a corresponding JWT OAuth2 token which can be
 * Obtained from the instance of bean
 * {@link BahiKhataTestToken}.The @activeProfile should be test for this to work
 * </p>
 * 
 * 
 * <p>
 * The {@link #username()} attribute must be provided with the username to be
 * sent for authentication.If left empty the default value is
 * <i><B>bahiKhataTestUser</i></B>
 * </p>
 * 
 * <p>
 * The {@link #password()} attribute must be provided with the password to be
 * sent for authentication.If left empty the default value is
 * <i><B>bahiKhataTestPassword</i></B>
 * </p>
 * 
 * <p>
 * The {@link #authorities()} attribute must be provided with the Array of
 * GrantedAuthorities to be sent for authentication.If left empty the default
 * value is <i><B>SecureService</i></B> The allowed values are <i><B>
 * <ol>
 * <li>SecureClient</li>
 * <li>SecureService</li>
 * <li>Admin</li>
 * <li>Manager</li>
 * </ol>
 * </i></B>
 * </p>
 * 
 * 
 * <p>
 * The {@link #scopes()} attribute must be provided with the scopes to be sent
 * for authentication.If left empty the default value is <i><B>read</i></B> The
 * allowed values are <i><B>
 * <ol>
 * <li>read</li>
 * <li>write</li>
 * </ol>
 * </i></B>
 * </p>
 * 
 * 
 * <p>
 * The {@link #clientId()} attribute must be provided with the clientId to be
 * sent for authentication.If left empty the default value is
 * <i><B>BahiKhataManagerReadTestClientId</i></B> The allowed values are <i><B>
 * <ol>
 * <li>BahiKhataManagerReadTestClientId</li>
 * <li>BahiKhataManagerWriteTestClientId</li>
 * <li>BahiKhataAdminReadTestClientId</li>
 * <li>BahiKhataAdminWriteTestClientId</li>
 * <li>BahiKhataSecureServiceReadTestClientId</li>
 * <li>BahiKhataSecureServiceWriteTestClientId</li>
 * <li>BahiKhataSecureClientIdReadTestClientId</li>
 * <li>BahiKhataSecureClientIdWriteTestClientId</li></i></B>
 * </ol>
 * </p>
 * 
 * <p>
 * The {@link #clientSecret()} attribute must be provided with the clientSecret
 * to be sent for authentication.If left empty the default value is
 * <i><B>BahiKhataManagerReadTestClientSecret</i></B> The allowed values are
 * <i><B>
 * <ol>
 * <li>BahiKhataManagerReadTestClientSecret</li>
 * <li>BahiKhataManagerWriteTestClientSecret</li>
 * <li>BahiKhataAdminReadTestClientSecret</li>
 * <li>BahiKhataAdminWriteTestClientSecret</li>
 * <li>BahiKhataSecureServiceReadTestClientSecret</li>
 * <li>BahiKhataSecureServiceWriteTestClientSecret</li>
 * <li>BahiKhataSecureClientSecretReadTestClientSecret</li>
 * <li>BahiKhataSecureClientSecretWriteTestClientSecret</li></i></B>
 * </ol>
 * </p>
 * 
 * @author Rudhra Koul
 * @since 28 Jul 2019
 * @version 0.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = BahiKhataTestAuthorizationServerConfig.class, setupBefore = TestExecutionEvent.TEST_EXECUTION)
public @interface BahiKhataMockUser {
	String username() default "bahiKhataTestUser";

	String[] authorities() default "SecureService";

	String password() default "bahiKhataTestPassword";

	String[] scopes() default "read";

	String clientId() default "BahiKhataManagerReadTestClientId";

	String clientSecret() default "BahiKhataManagerReadTestClientSecret";

}
