/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used as a Token Provider and
 * HttpHeader provider for Integration tests.
 * <p>
 * The token can be obtained from {@link #getToken()} method.It needs to be used
 * in combination with {@link BahiKhataMockUser} annotation,as the token is set
 * based on values provided in @BahiKhataMockUser annotation.
 * </p>
 * 
 * <P>
 * To write an integration test this class needs to be autowired and Each test
 * case needs to be annotated with @BahiKhataMockUser.The headers to be sent in
 * mock mvc request needs to be obtained from {@link #getHeaders()} and
 * {@link #getNoAuthHeaders()} methods. This method sets the Authorization
 * header and Content-Type header.ContentType By default is Application/json
 * </p>
 * 
 * @author Rudhra Koul
 * @since 28 Jul 2019
 * @version 1.0
 */
@Component
@Profile("test")
public class BahiKhataTestToken {
	String token;

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	public BahiKhataTestToken(String token) {
		this.token = token;
	}

	public BahiKhataTestToken() {
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method returns HttpHeaders with secure auth
	 * token
	 * 
	 * @author Rudhra Koul
	 * @since 28 Jul 2019
	 * @version 1.0
	 * @return
	 */
	public HttpHeaders getHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer " + this.getToken());
		return headers;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method returns HttpHeaders without secure
	 * auth token
	 * 
	 * @author Rudhra Koul
	 * @since 28 Jul 2019
	 * @version 1.0
	 * @return
	 */
	public HttpHeaders getNoAuthHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		return headers;
	}

}
