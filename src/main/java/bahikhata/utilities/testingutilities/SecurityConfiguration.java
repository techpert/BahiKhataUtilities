/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used to provide Mock
 * {@link AuthenticationManager} for integration tests
 * 
 * @author Rudhra Koul
 * @since 28 Jul 2019
 * @version 1.0
 */
@Configuration
@Profile("test")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
