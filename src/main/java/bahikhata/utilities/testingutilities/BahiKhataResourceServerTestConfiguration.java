/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */

package bahikhata.utilities.testingutilities;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used to configure the resource
 * server in test profile for integration tests on pipeline.To enable this we
 * need @ActiveProfile("test") on our test cases
 * 
 * @author Rudhra Koul
 * @since 27 Jul 2019
 * @version 1.0
 */
@Configuration
@EnableResourceServer
@Profile("test")
public class BahiKhataResourceServerTestConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer security) throws Exception {
		security.stateless(false);
		super.configure(security);
	}

}
