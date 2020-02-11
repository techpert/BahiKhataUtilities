/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.stringutilities;

import java.util.regex.PatternSyntaxException;

/**
 * Techpert:Bahikhata : 0.0.1 :This class has string related utilities
 * 
 * @author Rudhra Koul
 * 
 *
 */
public final class BahiKhataStringUtility {

	/**
	 * 
	 */
	private  BahiKhataStringUtility() {
		throw new UnsupportedOperationException(BahiKhataStringUtility.class.getSimpleName());
	}
	/**
	 * Techpert:Bahikhata : 0.0.1 :This method compares the string with the regex
	 * 
	 * @param s     String to match
	 * @param regex regex to match with
	 * @return true if the string s matches the regex exactly
	 *         false if s is null or pattern is invalid
	 * 
	 *
	 */
	public static boolean isMatchingPattern(String s, String regex) {
		try {
			return s!=null ?  s.matches(regex):false;
		} catch (PatternSyntaxException  e) {
			return false;
		}
		
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :Matches two strings safely
	 * 
	 * @param s1
	 * @param s2
	 * 
	 * @return true if 1:-either s1 and s2 are not null and not empty and s1 equals
	 *         s2. 2:-s1 equals s2 equals null. 3:-s1 and s2 are both blank. 4.In
	 *         all other cases it returns false
	 */
	public static boolean matchStringsSafely(String s1, String s2) {
		boolean matches = false;
		if (isNotNullAndNotEmpty(s1) && isNotNullAndNotEmpty(s2)) {
			if (s1.equalsIgnoreCase(s2)) {
				matches = true;
			}
		} else if (s1 == null && s2 == null) {
			matches = true;
		}  else if (s1 == null || s2 == null ) {
			matches = false;
		} else if (s1.equalsIgnoreCase("") && s1.equalsIgnoreCase(s2)) {
			matches = true;
		}
		return matches;

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :Checks if string is neither null nor empty
	 * 
	 * @param s1
	 * 
	 * @return true if string is neither null nor empty else returns false
	 */
	public static boolean isNotNullAndNotEmpty(String s1) {
		boolean notNullAndEmpty = false;
		if (((s1 != null) && (!s1.equalsIgnoreCase("")))) {
			notNullAndEmpty = true;
		}

		return notNullAndEmpty;

	}

}
