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
	 */
	public static void validateNullAndBlank(String objectToCheck, BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO,
			String code, String errorMsgNull, String errorMsgEmpty) {
		if (Objects.isNull(objectToCheck)) {
			bahiKhataErrorResponseDTO.putError(code, errorMsgNull);
		} else if (StringUtils.isBlank(objectToCheck)) {
			bahiKhataErrorResponseDTO.putError(code, errorMsgEmpty);
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
					BahiKhataExceptionHandlerConstants.BAHIKHATA_MISSING_REQUEST_BODY_RESPONSE_MESSAGE);
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
	 * @param fieldToValidate
	 * @param pattern
	 * @param bahiKhataErrorResponseDTO error response dto where errors will be
	 *                                  added
	 * @param code
	 * @param patternMismatchResponse
	 */
	public static void validatePatternMatch(String fieldToValidate, String pattern,
			BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO, String code, String patternMismatchResponse) {
		if (!BahiKhataStringUtility.isMatchingPattern(fieldToValidate, pattern)) {
			bahiKhataErrorResponseDTO.putError(code, patternMismatchResponse);
		}

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method checks two strings for equality and
	 * add corresponding error message to BahiKhataErrorResponseDTO
	 * 
	 * @author Rudhra Koul
	 * @since 9 Feb 2020
	 * @version 1.0
	 * @param field1
	 * @param feild2
	 * @param bahiKhataErrorResponseDTO error response dto where errors will be
	 *                                  added
	 * @param code
	 * @param mismatchResponse
	 */
	public static void validateEquality(String field1, String feild2,
			BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO, String code, String mismatchResponse) {
		if (!BahiKhataStringUtility.matchStringsSafely(field1, feild2)) {
			bahiKhataErrorResponseDTO.putError(code, mismatchResponse);
		}

	}

}
