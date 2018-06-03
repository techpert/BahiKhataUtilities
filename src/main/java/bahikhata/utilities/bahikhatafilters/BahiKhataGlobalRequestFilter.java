/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.bahikhatafilters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import bahikhata.utilities.authenticationutility.BahiKhataAuthenticationUtility;
import bahikhata.utilities.stringutilities.BahiKhataStringUtility;
import io.jsonwebtoken.SignatureException;

/**
 * Techpert:Bahikhata : 0.0.1 :GlobalRequestFilter to validate Authentication
 * token before forwarding the request
 * 
 * @author Rudhra Koul
 *
 */
@Component
public class BahiKhataGlobalRequestFilter implements HandlerInterceptor, BahiKhataGlobalRequestFilterConstantsIfc {

	/**
	 * Techpert:Bahikhata : 0.0.1 :Logger instance for Login
	 */
	private static Logger logger = LogManager.getLogger(BahiKhataGlobalRequestFilter.class);

	/**
	 * Techpert:Bahikhata : 0.0.1 : Default constructor.
	 */
	public BahiKhataGlobalRequestFilter() {

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 : This method intercepts every request to validate
	 * Authentication token before forwarding the request to BahiKhata Services/
	 * returns Unauthorised response(401) in case of error else forwarding the
	 * request to BahiKhata Services
	 * 
	 * @param requestContext
	 *            javax.ws.rs.container.ContainerRequestContext
	 *
	 * @return void
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Message m = logger.traceEntry("filter");
		logger.info("Fetching uriPath from requestContext");
		String uriPath = request.getRequestURI();

		try {
			if (BahiKhataStringUtility.isNotNullAndNotEmpty(uriPath)
					&& !PATHS_TO_IGNORE_AUTHENTICATION.contains(uriPath)
					&& !request.getMethod().equalsIgnoreCase("OPTIONS")) {
				logger.info("request should be filtered");
				logger.info("fetching Authentication Header");
				String authHeader = request.getHeader(AUTHENTICATION_HEADER);
				if (BahiKhataStringUtility.isNotNullAndNotEmpty(authHeader)) {
					logger.info("checkkng signature validity");
					boolean isAuthenticationTokenSignatureValid = BahiKhataAuthenticationUtility
							.isAuthenticationTokenSignatureValid(authHeader,
									BahiKhataAuthenticationUtility.getPublicKey());
					boolean isAuthenticationTokenExpired = false;
					if (isAuthenticationTokenSignatureValid) {
						logger.info("Token Signature Valid");
						isAuthenticationTokenExpired = BahiKhataAuthenticationUtility
								.isAuthenticationTokenExpired(authHeader);
						if (isAuthenticationTokenExpired) {
							logger.info("Token Expired");
							response.addHeader("error", SESSION_EXPIRED_RESPONSE_MESSAGE);
							response.setStatus(HttpStatus.UNAUTHORIZED.value());
							logger.traceExit(m);
							return false;

						} else {
							logger.info("Token Validation sucessful redirecting to ".concat(uriPath));
							logger.traceExit(m);
							return true;
						}

					} else {
						logger.info("Token Signature Invalid");
						response.addHeader("error", SESSION_EXPIRED_RESPONSE_MESSAGE);
						response.setStatus(HttpStatus.UNAUTHORIZED.value());
						logger.traceExit(m);
						return false;
					}
				} else {
					if (response.getStatus() == HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()) {
						response.addHeader("error", UNSUPPORTED_MEDIA_TYPE);
						response.getWriter().write(UNSUPPORTED_MEDIA_TYPE);
						response.getWriter().flush();
						System.out.println(response.isCommitted());
						return false;
					} else {

						logger.info("No Authentication Header found in request");
						response.addHeader("error", MISSING_AUTHENTICATION_TOKEN_RESPONSE_MESSAGE);
						System.out.println(response.getStatus());
						response.setStatus(HttpStatus.UNAUTHORIZED.value());
						System.out.println(response.getStatus());
						logger.traceExit(m);
						return false;
					}
				}
			} else {
				logger.info("Request for ".concat(uriPath).concat(" path.Request doesnt need to  be filtered"));
				logger.traceExit(m);
				return true;
			}

		} catch (SignatureException signatureException) {
			logger.debug("signature exception in authentication token ".concat(signatureException.getMessage()));
			response.addHeader("error", TAMPERED_AUTHENTICATION_TOKEN_RESPONSE_MESSAGE);
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			logger.traceExit(m);
			return false;
		}

	}

}
