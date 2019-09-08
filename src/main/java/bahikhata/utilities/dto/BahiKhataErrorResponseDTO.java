/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is
 * 
 * @author Namit.Jain
 * @since 19-Jul-2019
 * @version 1.0
 */
public class BahiKhataErrorResponseDTO implements Serializable {

	private static final long serialVersionUID = -7033929908475530176L;
	private List<HashMap<String, String>> errorList;

	/**
	 * @param errorList
	 */
	public BahiKhataErrorResponseDTO(List<HashMap<String, String>> errorList) {
		this.errorList = errorList;
	}

	/**
	 * 
	 */
	public BahiKhataErrorResponseDTO() {
		errorList = new ArrayList<>();
	}

	/**
	 * @return the errorList
	 */
	public List<HashMap<String, String>> getErrorList() {
		return errorList;
	}

	/**
	 * @param errorList the errorList to set
	 */
	public void setErrorList(List<HashMap<String, String>> errorList) {
		this.errorList = errorList;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method adds an error to the
	 * {@link BahiKhataErrorResponseDTO#errorList}
	 * 
	 * @author Namit.Jain
	 * @param key   String
	 * @param value String
	 */
	public void putError(String key, String value) {
		this.errorList.add(createErrorMap(key, value));
	}

	private HashMap<String, String> createErrorMap(String key, String value) {
		HashMap<String, String> errorMap = new HashMap<>();
		errorMap.put("code", key);
		errorMap.put("message", value);
		return errorMap;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method is string representation of
	 * {@link BahiKhataErrorResponseDTO}
	 * 
	 * @since 25-Aug-2019
	 * @return String representation BahiKhataErrorResponseDTO
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BahiKhataErrorResponseDTO [errorList=").append(errorList).append("]");
		return builder.toString();
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method is hashcode of BahiKhataErrorResponseDTO
	 * 
	 * @since 01-Sep-2019
	 * @return hashcode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(errorList);
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks equality of
	 * two objects of BahiKhataErrorResponseDTO class
	 * 
	 * @since 01-Sep-2019
	 * @param Object of BahiKhataErrorResponseDTO class
	 * @return true if equal
	 * 		   false if not equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BahiKhataErrorResponseDTO)) {
			return false;
		}
		BahiKhataErrorResponseDTO other = (BahiKhataErrorResponseDTO) obj;
		return Objects.equals(errorList, other.errorList);
	}


}
