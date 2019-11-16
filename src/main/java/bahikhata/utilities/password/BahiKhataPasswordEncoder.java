/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.password;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
* Techpert:Bahikhata : 0.0.1 :This class is used
 * @author Rudhra Koul 
 * @since 17 Nov 2019
 * @version 1.0
 */
@Component
public class BahiKhataPasswordEncoder implements PasswordEncoder{
	/**	
	 * Techpert:Bahikhata : 0.0.1 :Logger instance for BahiKhataManageUsers	
	 */	
	private static final Logger logger = LogManager.getLogger(BahiKhataPasswordEncoder.class);
	/**
	* Techpert:Bahikhata : 0.0.1 :This Method
	* @author Rudhra Koul
	 * @since 17 Nov 2019
	 * @version 1.0 
	 * @param rawPassword
	 * @return
	 */
	@Override
	public String encode(CharSequence rawPassword) {
		try {	
			int iterations = 500;	
			byte[] salt = getSalt();	
			PBEKeySpec spec = new PBEKeySpec(rawPassword.toString().toCharArray(), salt, iterations, 64 * 8);	
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(BahiKhataPasswordEncoderConstants.PASSWORD_BASED_KEY_DERIVATION_FUNCTION);	
			byte[] hash = secretKeyFactory.generateSecret(spec).getEncoded();	
			return iterations + BahiKhataPasswordEncoderConstants.ITERATION_FROM_SALTED_PWD_SEPARATOR + byteToHex(salt) + BahiKhataPasswordEncoderConstants.SALT_FROM_PWD_SEPARATOR	
					+ byteToHex(hash);	
		} catch (NoSuchAlgorithmException noSuchAlgorithmException) {	
			StringBuilder debugMessage = new StringBuilder(BahiKhataPasswordEncoderConstants.NO_SUCH_ALGO_EXCEPTION_MSG);	
			logger.debug(debugMessage.append(noSuchAlgorithmException.getMessage()).toString());	
		} catch (InvalidKeySpecException invalidKeySpecException) {	
			StringBuilder debugMessage = new StringBuilder(BahiKhataPasswordEncoderConstants.INVALID_KEY_SPEC_EXCEPTION_MSG);	
			logger.debug(debugMessage.append(invalidKeySpecException).toString());	
		}	
		return null;
	}
	/**	
	 * Techpert:Bahikhata : 0.0.1 : This method generates salt using SHA Pseudo	
	 * Random Number Generator Algorithm	
	 * 	
	 * @return salt byte []	
	 */	
	protected static byte[] getSalt() throws NoSuchAlgorithmException {	
		SecureRandom secureRandom = SecureRandom.getInstance(BahiKhataPasswordEncoderConstants.SHA1_RANDOM_NO_GENERATOR);	
		byte[] salt = new byte[16];	
		secureRandom.nextBytes(salt);	
		return salt;	
	}
	/**	
	 * Techpert:Bahikhata : 0.0.1 : This method generates hexadecimal equivalent of	
	 * the passed byte array	
	 * 	
	 * @param array	
	 *            byte[]	
	 * 	
	 * @return hex	
	 */	
	protected static String byteToHex(byte[] array) throws NoSuchAlgorithmException {	
		BigInteger bi = new BigInteger(1, array);	
		String hexEquivalent = bi.toString(16);	
		int paddingLength = (array.length * 2) - hexEquivalent.length();	
		if (paddingLength > 0) {	
			return String.format(BahiKhataPasswordEncoderConstants.ZERO_PADDING_APPENDER + paddingLength + BahiKhataPasswordEncoderConstants.INTEGER_FORMAT_SPECIFIER, 0) + hexEquivalent;	
		} else {	
			return hexEquivalent;	
		}	
	}
	/**	
	 * Techpert:Bahikhata : 0.0.1 : This method converts string to hexadecimal	
	 * equivalent	
	 * 	
	 * @param hex	
	 *            String	
	 * 	
	 * @return bytes byte[]	
	 */	
	protected static byte[] hexToByte(String hex) {	
		byte[] bytes = new byte[hex.length() / 2];	
		for (int i = 0; i < bytes.length; i++) {	
			bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);	
		}	
		return bytes;	
	}
	/**
	* Techpert:Bahikhata : 0.0.1 :This Method
	* @author Rudhra Koul
	 * @since 17 Nov 2019
	 * @version 1.0 
	 * @param rawPassword
	 * @param encodedPassword
	 * @return
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		int diff = 0;	
		try {	

			PBEKeySpec spec = new PBEKeySpec(rawPassword.toString().toCharArray(),	
					hexToByte((encodedPassword.split(BahiKhataPasswordEncoderConstants.ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]	
							.split(BahiKhataPasswordEncoderConstants.LITERAL_SALT_FROM_PWD_SEPARATOR)[0])),	
					Integer.parseInt(encodedPassword.split(BahiKhataPasswordEncoderConstants.ITERATION_FROM_SALTED_PWD_SEPARATOR)[0]),	
					hexToByte((encodedPassword.split(BahiKhataPasswordEncoderConstants.ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]	
							.split(BahiKhataPasswordEncoderConstants.LITERAL_SALT_FROM_PWD_SEPARATOR)[1])).length * 8);	
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(BahiKhataPasswordEncoderConstants.PASSWORD_BASED_KEY_DERIVATION_FUNCTION);	
			byte[] uiPwdHash = secretKeyFactory.generateSecret(spec).getEncoded();	
			diff = hexToByte((encodedPassword.split(BahiKhataPasswordEncoderConstants.ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]	
					.split(BahiKhataPasswordEncoderConstants.LITERAL_SALT_FROM_PWD_SEPARATOR)[1])).length ^ uiPwdHash.length;	
			for (int i = 0; i < hexToByte((encodedPassword.split(BahiKhataPasswordEncoderConstants.ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]	
					.split(BahiKhataPasswordEncoderConstants.LITERAL_SALT_FROM_PWD_SEPARATOR)[1])).length && i < uiPwdHash.length; i++) {	
				diff |= hexToByte((encodedPassword.split(BahiKhataPasswordEncoderConstants.ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]	
						.split(BahiKhataPasswordEncoderConstants.LITERAL_SALT_FROM_PWD_SEPARATOR)[1]))[i] ^ uiPwdHash[i];	
			}	

		} catch (NoSuchAlgorithmException noSuchAlgorithmException) {	

			StringBuilder debugMessage = new StringBuilder(BahiKhataPasswordEncoderConstants.NO_SUCH_ALGO_EXCEPTION_MSG);	
			logger.debug(debugMessage.append(noSuchAlgorithmException.getMessage()).toString());	

		} catch (InvalidKeySpecException invalidKeySpecException) {	
			StringBuilder debugMessage = new StringBuilder(BahiKhataPasswordEncoderConstants.INVALID_KEY_SPEC_EXCEPTION_MSG);	
			logger.debug(debugMessage.append(invalidKeySpecException).toString());	
		}	
		return diff == 0;
	}

}
