/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.TestSecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used to modify security context
 * during test execution
 * 
 * @author Rudhra Koul
 * @since 14 Oct 2019
 * @version 1.0
 */
@Component
@Profile("test")
public class BahiKhataSecurityContextTestUtility {

	@Autowired
	BahiKhataTestAuthorizationServerConfig bahiKhataTestAuthorizationServerConfig;

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method is used to reset security context
	 * within the test case
	 * 
	 * @author Rudhra Koul
	 * @since 14 Oct 2019
	 * @version 1.0
	 * @param bahiKhataMockUserImpl
	 * @return void
	 */
	public void createSecurityContext(BahiKhataMockUserImpl bahiKhataMockUserImpl) {
		BahiKhataMockUser bahiKhataMockUser = bahiKhataMockUserImpl.getBahiKhataMockUser();
		if (bahiKhataMockUser == null) {
			SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
			TestSecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
		} else {
			bahiKhataTestAuthorizationServerConfig.createSecurityContext(bahiKhataMockUser);
		}

	}
}
