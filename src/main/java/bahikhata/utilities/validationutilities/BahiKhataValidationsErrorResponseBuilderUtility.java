package bahikhata.utilities.validationutilities;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;

import bahikhata.utilities.dto.BahiKhataErrorResponseDTO;
import bahikhata.utilities.exception.handler.BahiKhataExceptionHandlerConstants;
import bahikhata.utilities.stringutilities.BahiKhataStringUtility;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used for validating
 * {@link BahiKhataDto}'s .This class should be extended for custom validation
 * scenarios
 * 
 * @author Rudhra Koul
 * @since 10 Feb 2020
 * @version 1.0
 */
public abstract class BahiKhataValidationsErrorResponseBuilderUtility {

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks String object for null and
	 * blank and add corresponding error message to BahiKhataErrorResponseDTO
	 * 
	 * @since 15-Sep-2019
	 * @param objectToCheck             object which needs to be validated
	 * @param bahiKhataErrorResponseDTO error response dto where errors will be
	 *                                  added
	 * @param code                      code to be added on
	 *                                  bahiKhataErrorResponseDTO when object is
	 *                                  null or empty
	 * @param errorMsgNull              error message to be added on
	 *                                  bahiKhataErrorResponseDTO when object is
	 *                                  null
	 * @param errorMsgEmpty             error message to be added on
	 *                                  bahiKhataErrorResponseDTO when object is
	 *                                  empty
	 *                                  
	 * @param fieldName                 name of the erroneous field
	 */
	public static void validateNullAndBlank(String fieldName,String objectToCheck, BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO,
			String code, String errorMsgNull, String errorMsgEmpty) {
		if (Objects.isNull(objectToCheck)) {
			bahiKhataErrorResponseDTO.putError(code, errorMsgNull,fieldName,objectToCheck);
		} else if (StringUtils.isBlank(objectToCheck)) {
			bahiKhataErrorResponseDTO.putError(code, errorMsgEmpty,fieldName,objectToCheck);
		}
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method null checks BahiKhataDTO's and add
	 * corresponding error message to BahiKhataErrorResponseDTO
	 * 
	 * @since 15-Sep-2019
	 * @param bahiKhataDTO              object which needs to be validated for null
	 *                                  check
	 * @param bahiKhataErrorResponseDTO error response dto where errors will be
	 *                                  added
	 * @return boolean<br/>
	 *         true - BahiKhataDTO is null <br/>
	 *         false - BahiKhataDTO is not null
	 */
	public static boolean validateBahiKhataDTO(Object bahiKhataDTO,
			BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO) {
		if (Objects.isNull(bahiKhataDTO)) {
			bahiKhataErrorResponseDTO.putError(
					BahiKhataExceptionHandlerConstants.BAHIKHATA_REQUEST_BODY_EXCEPTION_RESPONSE_KEY,
					BahiKhataExceptionHandlerConstants.BAHIKHATA_MISSING_REQUEST_BODY_RESPONSE_MESSAGE,null,null);
			return false;
		}
		return true;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method matches a string against a particular
	 * regex and add corresponding error message to BahiKhataErrorResponseDTO
	 * 
	 * @author Rudhra Koul
	 * @since 9 Feb 2020
	 * @version 1.0
	 * @param fieldName name of the field to validate
	 * @param fieldToValidate field to validate
	 * @param pattern
	 * @param bahiKhataErrorResponseDTO error response dto where errors will be
	 *                                  added
	 * @param code error code 
	 * @param patternMismatchResponse error message
	 */
	public static void validatePatternMatch(String fieldName, String fieldToValidate, String pattern,
			BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO, String code, String patternMismatchResponse) {
		if (!BahiKhataStringUtility.isMatchingPattern(fieldToValidate, pattern)) {
			bahiKhataErrorResponseDTO.putError(code, patternMismatchResponse,fieldName,fieldToValidate);
		}

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method checks two strings for equality and
	 * add corresponding error message to BahiKhataErrorResponseDTO
	 * 
	 * @author Rudhra Koul
	 * @since 9 Feb 2020
	 * @version 1.0
	 * @param field1Name Name of the first Field
	 * @param field2Name Name of the second Field
	 * @param field1 Value of first Field
	 * @param feild2 Value of Second Field
	 * @param bahiKhataErrorResponseDTO error response dto where errors will be
	 *                                  added
	 * @param code error code
	 * @param mismatchResponse error message 
	 */
	public static void validateEquality(String field1Name,String field2Name,String field1, String field2,
			BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO, String code, String mismatchResponse) {
		if (!BahiKhataStringUtility.matchStringsSafely(field1, field2)) {
			bahiKhataErrorResponseDTO.putError(code, mismatchResponse ,field1Name+" , "+ field2Name, field1+" , "+ field2);
		}

	}

}
