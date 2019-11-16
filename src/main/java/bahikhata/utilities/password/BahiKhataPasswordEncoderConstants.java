/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.password;

/**
* Techpert:Bahikhata : 0.0.1 :This class is used
 * @author Rudhra Koul 
 * @since 17 Nov 2019
 * @version 1.0
 */
public final class BahiKhataPasswordEncoderConstants {
/**
 * 
 */
public BahiKhataPasswordEncoderConstants() {
	throw new UnsupportedOperationException(BahiKhataPasswordEncoderConstants.class.getName());
}
public static final String PASSWORD_BASED_KEY_DERIVATION_FUNCTION = "PBKDF2WithHmacSHA1";	
public static final String ITERATION_FROM_SALTED_PWD_SEPARATOR = ":";	
public static final String SALT_FROM_PWD_SEPARATOR = ".";	
public static final String NO_SUCH_ALGO_EXCEPTION_MSG = "exception caught while generating hash because of noSuchAlgorithmException";	
public static final String INVALID_KEY_SPEC_EXCEPTION_MSG = "exception caught while generating hash because of invalidKeySpecException";	
public static final String SHA1_RANDOM_NO_GENERATOR = "SHA1PRNG";	
public static final String LITERAL_SALT_FROM_PWD_SEPARATOR = "\\.";	
public static final String ZERO_PADDING_APPENDER = "%0";	
public static final String INTEGER_FORMAT_SPECIFIER = "d";
}
