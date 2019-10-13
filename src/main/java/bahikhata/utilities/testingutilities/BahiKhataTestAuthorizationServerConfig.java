/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */

package bahikhata.utilities.testingutilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.test.context.TestSecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used to configure
 * {@link SecurityContext} and create a mock
 * {@link AuthorizationServerConfigurerAdapter} to allow mock users in
 * integration tests
 * 
 * @author Rudhra Koul
 * @since 27 Jul 2019
 * @version 1.0
 */
@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("test")
public class BahiKhataTestAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
		implements WithSecurityContextFactory<BahiKhataMockUser> {
	@Autowired
	AuthorizationServerTokenServices tokenservice;
	OAuth2AccessToken token;
	@Autowired
	BahiKhataTestToken bahiKhataTestToken;
	@Autowired
	ClientDetailsService clientDetailsService;
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	/**
	 * @return the token
	 */
	public OAuth2AccessToken getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(OAuth2AccessToken token) {
		this.token = token;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method acts as a mock
	 * {@link JwtAccessTokenConverter} for integration tests.
	 * <P>
	 * It uses default <B><i>bahikhatatestKey<B><i> as SigningKey and VerifierKey
	 * 
	 * @author Rudhra Koul
	 * @since 28 Jul 2019
	 * @version 1.0
	 * @return
	 * @throws Exception
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() throws Exception {
		JwtAccessTokenConverter jwt = new JwtAccessTokenConverter();
		jwt.setSigningKey("bahikhatatestKey");
		jwt.setVerifierKey("bahikhatatestKey");
		jwt.afterPropertiesSet();
		return jwt;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method sets a Mock authenticationManager and
	 * accessTokenConverter.
	 * 
	 * @author Rudhra Koul
	 * @since 28 Jul 2019
	 * @version 1.0
	 * @param endpoints
	 * @throws Exception
	 */
	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).accessTokenConverter(accessTokenConverter());
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method creates an in-memory list of default
	 * OAuth2 clients to be used for Integration tests It provides following client
	 * ID and client Secret pairs
	 * 
	 * <p>
	 * <i><B>BahiKhataManagerReadTestClientId</i></B> The allowed values are <i><B>
	 * <ol>
	 * <li>BahiKhataManagerReadTestClientId ,
	 * BahiKhataManagerReadTestClientSecret</li>
	 * <li>BahiKhataManagerWriteTestClientId,
	 * BahiKhataManagerWriteTestClientSecret</li>
	 * <li>BahiKhataAdminReadTestClientId, BahiKhataAdminReadTestClientSecret</li>
	 * <li>BahiKhataAdminWriteTestClientId, BahiKhataAdminWriteTestClientSecret</li>
	 * <li>BahiKhataSecureServiceReadTestClientId,
	 * BahiKhataSecureServiceReadTestClientSecret</li>
	 * <li>BahiKhataSecureServiceWriteTestClientId,
	 * BahiKhataSecureServiceWriteTestClientSecret</li>
	 * <li>BahiKhataSecureClientIdReadTestClientId,
	 * BahiKhataSecureClientSecretReadTestClientSecret</li>
	 * <li>BahiKhataSecureClientIdWriteTestClientId,
	 * BahiKhataSecureClientSecretWriteTestClientSecret</li></i></B>
	 * </ol>
	 * </p>
	 * 
	 * @author Rudhra Koul
	 * @since 28 Jul 2019
	 * @version 1.0
	 * @param clients
	 * @throws Exception
	 */
	@Override
	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("BahiKhataManagerReadTestClientId").secret("BahiKhataManagerReadTestClientSecret")
				.authorizedGrantTypes("password").authorities("Manager").scopes("read")

				.and().withClient("BahiKhataManagerWriteTestClientId").secret("BahiKhataManagerWriteTestClientSecret")
				.authorizedGrantTypes("password").authorities("Manager").scopes("write")

				.and().withClient("BahiKhataAdminReadTestClientId").secret("BahiKhataAdminReadTestClientSecret")
				.authorizedGrantTypes("password").authorities("Admin").scopes("read")

				.and().withClient("BahiKhataAdminWriteTestClientId").secret("BahiKhataAdminWriteTestClientSecret")
				.authorizedGrantTypes("password").authorities("Admin").scopes("write")

				.and().withClient("BahiKhataSecureServiceReadTestClientId")
				.secret("BahiKhataSecureServiceReadTestClientSecret").authorizedGrantTypes("password")
				.authorities("SecureService").scopes("read")

				.and().withClient("BahiKhataSecureServiceWriteTestClientId")
				.secret("BahiKhataSecureServiceWriteTestClientSecret").authorizedGrantTypes("password")
				.authorities("SecureService").scopes("write")

				.and().withClient("BahiKhataSecureClientReadTestClientId")
				.secret("BahiKhataSecureClientReadTestClientSecret").authorizedGrantTypes("password")
				.authorities("SecureClient").scopes("read")

				.and().withClient("BahiKhataSecureClientWriteTestClientId")
				.secret("BahiKhataSecureClientWriteTestClientSecret").authorizedGrantTypes("password")
				.authorities("SecureClient").scopes("write");
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method creates the security context based on
	 * the values provided in @BahiKhataMockUser annotation. This also sets the
	 * token to the singleton bean {@link BahiKhataTestToken}
	 * 
	 * @author Rudhra Koul
	 * @since 28 Jul 2019
	 * @version 1.0
	 * @param annotation
	 * @return
	 */
	@Override
	public SecurityContext createSecurityContext(BahiKhataMockUser bahiKhataMockUser) {
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		try {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			String[] authorities = bahiKhataMockUser.authorities();
			for (int i = 0; i < authorities.length; i++) {
				GrantedAuthority authority = new SimpleGrantedAuthority(authorities[i]);
				grantedAuthorities.add(authority);
			}

			Set<String> scopes = new HashSet(Arrays.asList(bahiKhataMockUser.scopes()));

			Map<String, String> requestParameters = Collections.emptyMap();
			boolean approved = true;
			String redirectUrl = null;
			Set<String> responseTypes = Collections.emptySet();
			Map<String, Serializable> extensionProperties = Collections.emptyMap();

			OAuth2Request oAuth2Request = new OAuth2Request(requestParameters, bahiKhataMockUser.clientId(),
					grantedAuthorities, approved, scopes, null, redirectUrl, responseTypes, extensionProperties);

			User userPrincipal = new User(bahiKhataMockUser.username(), bahiKhataMockUser.password(), true, true, true,
					true, grantedAuthorities);
			Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal,
					userPrincipal.getPassword(), userPrincipal.getAuthorities());
			OAuth2Authentication auth = new OAuth2Authentication(oAuth2Request, authenticationToken);
			token = tokenservice.createAccessToken(auth);
			bahiKhataTestToken.setToken(token.getValue());
			context.setAuthentication(auth);
			TestSecurityContextHolder.setContext(context);
			return context;
		} catch (NoSuchClientException e) {
			bahiKhataTestToken.setToken(null);
			return context;
		}
	}
	
}
