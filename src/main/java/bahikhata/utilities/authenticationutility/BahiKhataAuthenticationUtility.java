/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.authenticationutility;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;

import bahikhata.utilities.datetimeutilities.BahiKhataDateTimeConstantsIfc;
import bahikhata.utilities.datetimeutilities.BahiKhataDateTimeUtility;
import bahikhata.utilities.stringutilities.BahiKhataStringUtility;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * @author Rudhra Koul This class has Authentication related utilities
 *
 */
public class BahiKhataAuthenticationUtility implements BahiKhataAuthenticationConstantsIfc {
	/**
	 * Techpert:Bahikhata : 0.0.1 :Logger instance for
	 * BahiKhataAuthenticationUtility
	 */
	private static Logger logger = LogManager.getLogger(BahiKhataAuthenticationUtility.class);

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method generates the Authentication Token
	 * for logged in user
	 * 
	 * @param user
	 *            bahikhata.users.model.User
	 *
	 * @return authenticationToken String on success else null
	 * 
	 */
	public static String getAuthenticationTokenForUser(String userFirstName) {
		Message m = logger.traceEntry("getAuthenticationToken");
		KeyStore keyStore = loadKeystore();
		Key key = getKeyFromKeyStore(keyStore);

		String authenticationToken = null;
		if (BahiKhataStringUtility.isNotNullAndNotEmpty(userFirstName)) {
			logger.info("Setting claims in authenticationToken");
			Map<String, Object> claims = new HashMap<>();
			claims.put(CLAIM_USER_FIRST_NAME, userFirstName);
			claims.put(CLAIM_EXPIRATION_DATE,
					BahiKhataDateTimeUtility.getTimestampAfterNHours(TOKEN_EXPIRATION_OFFSET).toString());
			logger.info("Signing and generating authenticationToken");
			authenticationToken = Jwts.builder().setClaims(claims).setIssuer(TOKEN_ISSED_BY)
					.signWith(SignatureAlgorithm.RS256, key).compact();
			logger.info("authenticationToken generated successfully");
		} else {
			logger.debug("Error while generating authenticationToken. User or userName is null");
		}
		logger.traceExit(m);
		return authenticationToken;

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method returns publicKey
	 * 
	 * @return publicKey java.security.PublicKey on success else null
	 * 
	 */
	public static PublicKey getPublicKey() {
		Message m = logger.traceEntry("getPublicKey");

		Certificate certificate = getCertificate();

		PublicKey publicKey = null;
		if (certificate != null) {
			logger.info("Generating public key from certificate");
			publicKey = certificate.getPublicKey();
			logger.info("Certificate generated successfully");
		} else {
			logger.debug("Certificate not found!!!");
		}
		logger.traceExit(m);
		return publicKey;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method generates publicKey from certificate
	 * 
	 * @param certificate
	 *            java.security.cert.Certificate
	 * 
	 * @return publicKey java.security.PublicKey on success else null
	 * 
	 */
	public static PublicKey getPublicKeyFromCertificate(Certificate certificate) {
		Message m = logger.traceEntry("getPublicKeyFromCertificate");

		PublicKey publicKey = null;
		if (certificate != null) {
			logger.info("Generating public key from certificate");
			publicKey = certificate.getPublicKey();
			logger.info("Certificate generated successfully");
		} else {
			logger.debug("Certificate not found!!!");
		}
		logger.traceExit(m);
		return publicKey;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method fetches claim value from claimKey
	 * 
	 * @param token
	 *            String
	 * 
	 * @param publicKey
	 *            java.security.PublicKey
	 * 
	 * @param claimKey
	 *            String
	 * 
	 * @return claimValue String if claimKey exists else null
	 * 
	 */
	public static String getClaimValueFromToken(String token, PublicKey publicKey, String claimKey) {
		Message m = logger.traceEntry("getClaimValueFromToken");
		logger.info("Fetching claim Value from claims map");
		Object claimValueObject = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token).getBody().get(claimKey);
		String claimValue = null;
		if (claimValueObject != null) {
			logger.info("Got a claim Value object generating claimValue string");
			claimValue = claimValueObject.toString();
			if (!BahiKhataStringUtility.isNotNullAndNotEmpty(claimValue)) {
				claimValue = null;
				logger.info("claimValue is empty");
			} else {
				logger.info("ClaimValue string computed successfully");
			}
		} else {
			logger.info("ClaimKey not found in claims Map");
		}
		logger.traceExit(m);
		return claimValue;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks if authenticationToken is
	 * expired
	 * 
	 * @param authenticationToken
	 *            String
	 *
	 * @return boolean true if expired else false
	 * 
	 */
	public static boolean isAuthenticationTokenExpired(String authenticationToken) {
		Message m = logger.traceEntry("isAuthenticationTokenExpired");
		logger.info("Fetching expiry Date from authenticationToken");
		String expiryClaimValue = getClaimValueFromToken(authenticationToken, getPublicKey(), CLAIM_EXPIRATION_DATE);
		ZonedDateTime expiryDate = null;
		if (BahiKhataStringUtility.isNotNullAndNotEmpty(expiryClaimValue)) {
			logger.info("Valid Expiration Date claim value fetched from authenticationToken");
			if (BahiKhataDateTimeUtility.isTimeZoneAfterGMT(expiryClaimValue)) {
				logger.info("Converting expiryDate claim Value to zonedDateTime");
				expiryDate = BahiKhataDateTimeUtility.convertStringDateToZonedDateTime(expiryClaimValue,
						BahiKhataDateTimeConstantsIfc.GMT_AFTER);
			} else {
				expiryDate = BahiKhataDateTimeUtility.convertStringDateToZonedDateTime(expiryClaimValue,
						BahiKhataDateTimeConstantsIfc.GMT_BEFORE);
			}
		} else {
			logger.debug("could not find expiry date claim in authenticationToken");
		}
		logger.traceExit(m);
		return BahiKhataDateTimeUtility.isDateExpired(expiryDate);

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks if signature is valid
	 * 
	 * @param authenticationToken
	 *            String
	 * 
	 * @param publicKey
	 *            java.security.PublicKey
	 *
	 * @return isValidSignature boolean
	 * 
	 * @throws SignatureException
	 *             io.jsonwebtoken.SignatureException
	 * 
	 */
	public static boolean isAuthenticationTokenSignatureValid(String authenticationToken, PublicKey publicKey)
			throws SignatureException {
		Message m = logger.traceEntry("isAuthenticationTokenSignatureValid");
		boolean isValidSignature = false;
		try {
			Jwts.parser().setSigningKey(publicKey).parseClaimsJws(authenticationToken).getBody().getIssuer()
					.equals(TOKEN_ISSED_BY);
			isValidSignature = true;
		} catch (UnsupportedJwtException unsupportedJwtException) {
			logger.debug("Unsupported authenticationToken" + unsupportedJwtException.getMessage());

		} catch (MalformedJwtException malformedJwtException) {
			logger.debug("Malformed authenticationToken" + malformedJwtException.getMessage());
		} catch (SignatureException signatureException) {
			logger.debug("Invalid Signature in authenticationToken" + signatureException.getMessage());
			throw signatureException;

		} catch (IllegalArgumentException illegalArgumentException) {
			logger.debug("illegal arguments in authenticationToken" + illegalArgumentException.getMessage());
		}
		return logger.traceExit(m, isValidSignature);
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks if authentication token is
	 * scheduled to expire soon
	 * 
	 * @param authenticationToken
	 *            String
	 *
	 * @return isRefreshEligible boolean
	 */
	public static boolean isAuthenticationTokenNearExpiration(String authenticationToken) {
		Message m = logger.traceEntry("isAuthenticationTokenNearExpiration");
		boolean isRefreshEligible = false;
		String expiryClaimValue = getClaimValueFromToken(authenticationToken, getPublicKey(), CLAIM_EXPIRATION_DATE);
		ZonedDateTime expiryDate = null;
		if (BahiKhataStringUtility.isNotNullAndNotEmpty(expiryClaimValue)) {
			logger.info("Valid Expiration Date claim value fetched from authenticationToken");
			if (BahiKhataDateTimeUtility.isTimeZoneAfterGMT(expiryClaimValue)) {
				logger.info("Converting expiryDate claim Value to zonedDateTime");
				expiryDate = BahiKhataDateTimeUtility.convertStringDateToZonedDateTime(expiryClaimValue,
						BahiKhataDateTimeConstantsIfc.GMT_AFTER);
			} else {
				expiryDate = BahiKhataDateTimeUtility.convertStringDateToZonedDateTime(expiryClaimValue,
						BahiKhataDateTimeConstantsIfc.GMT_BEFORE);
			}
		} else {
			logger.debug("could not find expiry date claim in authenticationToken");
		}
		logger.info("Calculating time left in expiry");
		Duration expiryDuration = Duration.between(BahiKhataDateTimeUtility.getcurrentZonedDateTime(), expiryDate);
		long expiryDurationInMinutes = expiryDuration.toMinutes();

		int sign = Long.signum(expiryDurationInMinutes);
		if (sign != -1 && sign != 0 && Math.abs(expiryDurationInMinutes) < REFRESH_TOKEN_THRESHOLD) {
			isRefreshEligible = true;

		}
		return logger.traceExit(m, isRefreshEligible);
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method refreshes the near expiry
	 * currentAuthenticationToken and generates a new authenticationToken
	 * 
	 * @param currentAuthenticationToken
	 *            String
	 *
	 * @return authenticationToken String
	 */
	public static String refreshAuthenticationTokenForUser(String currentAuthenticationToken) {
		Message m = logger.traceEntry("refreshAuthenticationTokenForUser");
		String authenticationToken = null;
		Map<String, Object> claims = new HashMap<>();
		if (BahiKhataStringUtility.isNotNullAndNotEmpty(currentAuthenticationToken)) {
			logger.info("generating authenticationToken for new authentication");
			claims.put(CLAIM_USER_FIRST_NAME,
					getClaimValueFromToken(currentAuthenticationToken, getPublicKey(), CLAIM_USER_FIRST_NAME));
			claims.put(CLAIM_EXPIRATION_DATE,
					BahiKhataDateTimeUtility.getTimestampAfterNHours(TOKEN_EXPIRATION_OFFSET).toString());
			authenticationToken = Jwts.builder().setClaims(claims).setIssuer(TOKEN_ISSED_BY)
					.signWith(SignatureAlgorithm.RS256, getKeyFromKeyStore(loadKeystore())).compact();
			logger.info("new authenticationToken generated");
		} else {
			logger.debug("supplied authentication token is null");
		}
		logger.traceExit(m);
		return authenticationToken;

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method fetches key from the keystore
	 * 
	 * @param keyStore
	 *            java.security.KeyStore
	 *
	 * @return Key java.security.Key
	 */
	public static Key getKeyFromKeyStore(KeyStore keyStore) {
		Message m = logger.traceEntry("getKeyFromKeyStore");
		String alias = getAliasFromKeyStore(keyStore);
		Key key = null;
		if (keyStore != null && BahiKhataStringUtility.isNotNullAndNotEmpty(alias)) {
			try {
				key = keyStore.getKey(alias, KEYSTORE_PASSWORD.toCharArray());
			} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
				logger.debug("exception caught while fetching key from the key store " + e.getMessage());
			}
		} else {
			logger.debug("no aliases found in the key store or keystore is null");
		}
		logger.traceExit(m);
		return key;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method loads keystore from classpath
	 * 
	 * @return keyStore java.security.KeyStore
	 */
	public static KeyStore loadKeystore() {
		Message m = logger.traceEntry("loadKeystore");
		InputStream inputStream = BahiKhataAuthenticationUtility.class.getClassLoader()
				.getResourceAsStream(SERVER_CERTIFICATE);
		KeyStore keyStore = null;
		if (inputStream != null) {
			try {
				keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			} catch (KeyStoreException keyStoreException) {
				logger.debug(keyStoreException.getMessage());
			}
			try {
				keyStore.load(inputStream, KEYSTORE_PASSWORD.toCharArray());
				logger.info("keyStore loaded");
			} catch (NoSuchAlgorithmException | CertificateException | IOException e) {
				logger.debug(e.getMessage());
			}
		} else {
			logger.debug("Could not load keystore from classpath");
		}
		logger.traceExit(m);
		return keyStore;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method fetches certificate alias from the
	 * keystore
	 * 
	 * @param keyStore
	 *            java.security.KeyStore
	 *
	 * @return alias String
	 */
	public static String getAliasFromKeyStore(KeyStore keyStore) {
		Message m = logger.traceEntry("getAliasFromKeyStore");
		Enumeration<String> aliases = null;
		String alias = null;
		if (keyStore != null) {
			try {
				logger.info("fetching aliases from keyStore");
				aliases = keyStore.aliases();
			} catch (KeyStoreException keyStoreException) {
				logger.debug(keyStoreException.getMessage());
			}
			alias = null;
			while (aliases.hasMoreElements()) {
				alias = aliases.nextElement();
			}
		} else {
			logger.debug("Supplied keystore is not valid");
		}
		logger.traceExit(m);
		return alias;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method fetches certificate alias from the
	 * keystore
	 * 
	 *
	 * @return alias String
	 */
	public static String getAliasFromKeyStore() {
		Message m = logger.traceEntry("getAliasFromKeyStore");
		KeyStore keyStore = loadKeystore();
		Enumeration<String> aliases = null;
		String alias = null;
		if (keyStore != null) {
			try {
				logger.info("fetching aliases from keyStore");
				aliases = keyStore.aliases();
			} catch (KeyStoreException keyStoreException) {
				logger.debug(keyStoreException.getMessage());
			}
			alias = null;
			while (aliases.hasMoreElements()) {
				alias = aliases.nextElement();
			}
		} else {
			logger.debug("Could not load keystore from classpath");
		}
		logger.traceExit(m);
		return alias;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method fetches Certificate from keyStore
	 *
	 * @return certificate java.security.cert.Certificate
	 */
	public static Certificate getCertificate() {
		Message m = logger.traceEntry("getCertificate");
		KeyStore keyStore = loadKeystore();

		String alias = null;
		if (keyStore != null) {
			alias = getAliasFromKeyStore(keyStore);
		} else {
			logger.debug("Supplied keystore is not valid");
		}
		Certificate certificate = null;
		if (BahiKhataStringUtility.isNotNullAndNotEmpty(alias)) {
			try {
				certificate = keyStore.getCertificate(alias);
				logger.info("Fetched certificate from keyStore");
			} catch (KeyStoreException keyStoreException) {
				logger.debug(keyStoreException.getMessage());
			}
		} else {
			logger.debug("Could not find any aliases in the keyStore");
		}
		logger.traceExit(m);
		return certificate;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method fetches Certificate from supplied
	 * keyStore
	 *
	 * @param keyStore
	 *            java.security.KeyStore
	 *
	 * @return certificate java.security.cert.Certificate
	 */
	public static Certificate getCertificate(KeyStore keyStore) {
		Message m = logger.traceEntry("getCertificate");

		String alias = null;
		if (keyStore != null) {
			alias = getAliasFromKeyStore(keyStore);
		} else {
			logger.debug("Supplied keystore is not valid");
		}
		Certificate certificate = null;
		if (BahiKhataStringUtility.isNotNullAndNotEmpty(alias)) {
			try {
				certificate = keyStore.getCertificate(alias);
				logger.info("Fetched certificate from keyStore");
			} catch (KeyStoreException keyStoreException) {
				logger.debug(keyStoreException.getMessage());
			}
		} else {
			logger.debug("Could not find any aliases in the keyStore");
		}
		logger.traceExit(m);
		return certificate;
	}
}
