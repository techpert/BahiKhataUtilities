/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used to report validation errors
 * 
 * @author Rudhra Koul
 * @since 11 Feb 2020
 * @version 1.0
 */

public class BahiKhataErrorDTO implements Serializable {
	private static final long serialVersionUID = -7033929908475530176L;

	String code;
	String message;
	@JsonInclude(Include.NON_EMPTY)
	String field;
	@JsonInclude(Include.NON_NULL)
	String value;

	/**
	 * 
	 */
	public BahiKhataErrorDTO() {
	}

	/**
	 * @param code
	 * @param message
	 * @param field
	 * @param value
	 */
	public BahiKhataErrorDTO(String code, String message, String field, String value) {
		this.code = code;
		this.message = message;
		this.field = field;
		this.value = value;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method is hashcode of {@link BahiKhataErrorDTO}
	 * 
	 * @author Rudhra Koul
	 * @since 11 Feb 2020
	 * @version 1.0
	 * @return hashcode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(code, field, message, value);
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method checks equality of two objects of {@link BahiKhataErrorDTO}
	 * 
	 * @author Rudhra Koul
	 * @since 11 Feb 2020
	 * @version 1.0
	 * @param obj Object of BahiKhataErrorDTO class
	 * @return true if equal false if not equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BahiKhataErrorDTO)) {
			return false;
		}
		BahiKhataErrorDTO other = (BahiKhataErrorDTO) obj;
		return Objects.equals(code, other.code) && Objects.equals(field, other.field)
				&& Objects.equals(message, other.message) && Objects.equals(value, other.value);
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method string representation of {@link BahiKhataErrorDTO}
	 * 
	 * @author Rudhra Koul
	 * @since 11 Feb 2020
	 * @version 1.0
	 * @return
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BahiKhataErrorDTO [code=").append(code).append(", message=").append(message).append(", field=")
				.append(field).append(", value=").append(value).append("]");
		return builder.toString();
	}

}
