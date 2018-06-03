/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhatautilities.test.encryptiondecryptionutility.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import bahikhata.utilities.encryptiondecryptionutility.BahiKhataEncryptionDecryptionUtil;

/**
 * @author Vrinda This class is used to test the functionalities of BahiKhataEncryptionDecryptionUtility class
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class BahiKhataUtilitiesEncryptionDecryptionUtilityTest {

	BahiKhataEncryptionDecryptionUtil bahiKhataEncryptionDecryptionUtil = new BahiKhataEncryptionDecryptionUtil();
	@Test
	void hashShouldBeGenerated()
	{
		String generatedHash = 	BahiKhataEncryptionDecryptionUtil.generateHash("");
		assertNotEquals("",generatedHash);
	}
	

}
