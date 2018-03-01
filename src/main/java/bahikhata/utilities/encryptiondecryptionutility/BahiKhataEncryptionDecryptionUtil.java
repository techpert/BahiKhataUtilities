/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.encryptiondecryptionutility;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vrinda This class provides methods for encryption and decryption of
 *         passwords
 *
 */
public class BahiKhataEncryptionDecryptionUtil implements BahiKhataEncryptionDecryptionConstantsIfc {

	/**
	 * Techpert:Bahikhata : 0.0.1 :Logger instance for BahiKhataManageUsers
	 */
	private static Logger logger = LogManager.getLogger(BahiKhataEncryptionDecryptionUtil.class);

	// Techpert:Bahikhata : 0.0.1 : Methods for Encryption of Password

	/**
	 * Techpert:Bahikhata : 0.0.1 : This method generates hash using salt and
	 * password
	 * 
	 * @param Salt
	 *            Byte[]
	 * @param password
	 *            String
	 * 
	 * @return hashedPassword String
	 */
	public static String generateHash(String password) {
		try {
			int iterations = 500;
			char[] passwordCharArray = password.toCharArray();
			byte[] salt = getSalt();
			PBEKeySpec spec = new PBEKeySpec(passwordCharArray, salt, iterations, 64 * 8);
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PASSWORD_BASED_KEY_DERIVATION_FUNCTION);
			byte[] hash = secretKeyFactory.generateSecret(spec).getEncoded();
			return iterations + ITERATION_FROM_SALTED_PWD_SEPARATOR + byteToHex(salt) + SALT_FROM_PWD_SEPARATOR
					+ byteToHex(hash);
		} catch (NoSuchAlgorithmException noSuchAlgorithmException) {
			StringBuilder debugMessage = new StringBuilder(NO_SUCH_ALGO_EXCEPTION_MSG);
			logger.debug(debugMessage.append(noSuchAlgorithmException.getMessage()).toString());
		} catch (InvalidKeySpecException invalidKeySpecException) {
			StringBuilder debugMessage = new StringBuilder(INVALID_KEY_SPEC_EXCEPTION_MSG);
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
		SecureRandom secureRandom = SecureRandom.getInstance(SHA1_RANDOM_NO_GENERATOR);
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
			return String.format(ZERO_PADDING_APPENDER + paddingLength + INTEGER_FORMAT_SPECIFIER, 0) + hexEquivalent;
		} else {
			return hexEquivalent;
		}
	}

	// Techpert:Bahikhata : 0.0.1 : Methods for Decryption of Password
	/**
	 * Techpert:Bahikhata : 0.0.1 : This method generates hash using salt and
	 * password
	 * 
	 * @param Salt
	 *            Byte[]
	 * @param password
	 *            String
	 * 
	 * @return hashedPassword String
	 */
	public static boolean validate(String passwordFromUI, String storedPassword) {
		int diff = 0;
		try {

			PBEKeySpec spec = new PBEKeySpec(passwordFromUI.toCharArray(),
					hexToByte((storedPassword.split(ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]
							.split(LITERAL_SALT_FROM_PWD_SEPARATOR)[0])),
					Integer.parseInt(storedPassword.split(ITERATION_FROM_SALTED_PWD_SEPARATOR)[0]),
					hexToByte((storedPassword.split(ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]
							.split(LITERAL_SALT_FROM_PWD_SEPARATOR)[1])).length * 8);
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PASSWORD_BASED_KEY_DERIVATION_FUNCTION);
			byte[] uiPwdHash = secretKeyFactory.generateSecret(spec).getEncoded();
			diff = hexToByte((storedPassword.split(ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]
					.split(LITERAL_SALT_FROM_PWD_SEPARATOR)[1])).length ^ uiPwdHash.length;
			for (int i = 0; i < hexToByte((storedPassword.split(ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]
					.split(LITERAL_SALT_FROM_PWD_SEPARATOR)[1])).length && i < uiPwdHash.length; i++) {
				diff |= hexToByte((storedPassword.split(ITERATION_FROM_SALTED_PWD_SEPARATOR)[1]
						.split(LITERAL_SALT_FROM_PWD_SEPARATOR)[1]))[i] ^ uiPwdHash[i];
			}

		} catch (NoSuchAlgorithmException noSuchAlgorithmException) {

			StringBuilder debugMessage = new StringBuilder(NO_SUCH_ALGO_EXCEPTION_MSG);
			logger.debug(debugMessage.append(noSuchAlgorithmException.getMessage()).toString());

		} catch (InvalidKeySpecException invalidKeySpecException) {
			StringBuilder debugMessage = new StringBuilder(INVALID_KEY_SPEC_EXCEPTION_MSG);
			logger.debug(debugMessage.append(invalidKeySpecException).toString());
		}
		return diff == 0;
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

}
