/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhatautilities.test.datetimeutilities.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import bahikhata.utilities.datetimeutilities.BahiKhataDateTimeUtility;

/**
 * @author Vrinda
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public final class BahiKhataUtilitiesDateTimeUtilityTest {

	@Test
	public void testGetCurrentDateString() {
		StringTokenizer tokenizer = new StringTokenizer(BahiKhataDateTimeUtility.getCurrentDateString(), "/");
		int[] dateArray = new int[3];
		int counter = 0;
		while (tokenizer.hasMoreTokens()) {
			dateArray[counter] = Integer.parseInt(tokenizer.nextToken());
			counter++;
		}
		assertEquals(LocalDate.now().getYear(), dateArray[0]);
		assertEquals(LocalDate.now().getMonthValue(), dateArray[1]);
		assertEquals(LocalDate.now().getDayOfMonth(), dateArray[2]);

	}
	@Test
	public void test() {
		StringTokenizer tokenizer = new StringTokenizer(BahiKhataDateTimeUtility.getCurrentDateString(), "/");
		int[] dateArray = new int[3];
		int counter = 0;
		while (tokenizer.hasMoreTokens()) {
			dateArray[counter] = Integer.parseInt(tokenizer.nextToken());
			counter++;
		}
		assertEquals(LocalDate.now().getYear(), dateArray[0]);
		assertEquals(LocalDate.now().getMonthValue(), dateArray[1]);
		assertEquals(LocalDate.now().getDayOfMonth(), dateArray[2]);

	}
}
