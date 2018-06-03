/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.bahikhatafilters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import bahikhata.utilities.authenticationutility.BahiKhataAuthenticationUtility;
import bahikhata.utilities.stringutilities.BahiKhataStringUtility;
import io.jsonwebtoken.SignatureException;

/**
 * @author Rudhra Koul
 *
 */
@Component
public class BahiKhataGlobalResponseFilter extends OncePerRequestFilter
		implements BahiKhataGlobalRequestFilterConstantsIfc {

	/**
	 * Techpert:Bahikhata : 0.0.1 :Logger instance for Login
	 */
	private static Logger logger = LogManager.getLogger(BahiKhataGlobalResponseFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(response) {
			@Override
			public void setStatus(int sc) {
				super.setStatus(sc);
				handleStatus(sc);
			}

			@Override
			public void sendError(int sc, String msg) throws IOException {
				super.sendError(sc, msg);
				handleStatus(sc);
			}

			@Override
			public void sendError(int sc) throws IOException {
				super.sendError(sc);
				handleStatus(sc);
			}

			private void handleStatus(int code) {

				Message m = logger.traceEntry("filter");

				try {
					logger.info("request should be filtered");
					logger.info("Fetching uriPath from requestContext");
					String uriPath = request.getRequestURI();
					logger.info("fetching Authentication Header");
					String authHeader = request.getHeader(AUTHENTICATION_HEADER);
					if (BahiKhataStringUtility.isNotNullAndNotEmpty(authHeader)) {
						logger.info("checkkng if token near expiry");
						boolean isAuthenticationNearExpiry = BahiKhataAuthenticationUtility
								.isAuthenticationTokenNearExpiration(authHeader);
						String refreshedToken = null;
						if (isAuthenticationNearExpiry) {
							logger.info("Token near expiry");
							refreshedToken = BahiKhataAuthenticationUtility
									.refreshAuthenticationTokenForUser(authHeader);
							logger.info("refreshing token");
							addHeader(AUTHENTICATION_HEADER, refreshedToken);
							logger.info("refreshed Token set");

						} else {
							logger.info("Token valid and not near expiry");
							addHeader(AUTHENTICATION_HEADER, authHeader);
							logger.info(" Token echoed back in response");

						}
					} else if (!PATHS_TO_IGNORE_AUTHENTICATION.contains(uriPath)) {
						logger.info("Auth failed");
					}

				} catch (SignatureException signatureException) {
					logger.debug(
							"signature exception in authentication token ".concat(signatureException.getMessage()));
					addHeader("error", TAMPERED_AUTHENTICATION_TOKEN_RESPONSE_MESSAGE);
					setStatus(HttpStatus.UNAUTHORIZED.value());
				}
				logger.traceExit(m);

			}
		};
		filterChain.doFilter(request, wrapper);

	}

}
