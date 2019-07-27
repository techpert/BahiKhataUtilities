/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.addressutility;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author Rudhra Koul 
 *
 */
public interface BahiKhataAddressValidationConstantsIfc {
public static final ArrayList<String> INDIAN_STATES= new ArrayList<String>() {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	{
		add("Andra Pradesh");
		add("Arunachal Pradesh");
		add("Assam");
		add("Bihar");
		add("Chhattisgarh");
		add("Goa");
		add("Gujarat");
		add("Haryana");
		add("Himachal Pradesh");
		add("Jammu and Kashmir");
		add("Jharkhand");
		add("Karnataka");
		add("Kerala");
		add("Madya Pradesh");
		add("Maharashtra");
		add("Manipur");
		add("Meghalaya");
		add("Mizoram");
		add("Nagaland");
		add("Orissa");
		add("Punjab");
		add("Rajasthan");
		add("Sikkim");
		add("Tamil Nadu");
		add("Tripura");
		add("Uttaranchal");
		add("Uttar Pradesh");
		add("West Bengal");
		add("Andaman and Nicobar Islands");	
		add("Chandigarh");
		add("Dadar and Nagar Haveli");
		add("Daman and Diu");
		add("Delhi");
		add("Lakshadeep");
		add("Pondicherry");
	}
};
public static final Predicate<String> indianStateValidation = state -> INDIAN_STATES.contains(state);
public static final String INVALID_STATE_ERROR = "state is  invalid " +". It shold be one of : " + INDIAN_STATES;
/*
 * This is the RegEx for validating pin code  entered by user.It should be a 6
 * digit number
 */
public static final String PIN_CODE_REGEX = "\\d{6}";

public static final Predicate<String> indianPinCodeValidation = pincode -> pincode.matches(PIN_CODE_REGEX);

}
