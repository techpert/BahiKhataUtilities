/**
 * copyright © 2018 Techpert It Solutions Private Limited
 */

package bahikhata.utilities.model;

import java.io.Serializable;

/**
 * Techpert:Bahikhata : 0.0.1 : The persistent class for the CUSTOMER database
 * table.
 * 
 * @author Surbhi.Gupta
 */
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private int customerId;

	private String custCategory;

	private String custComment;

	private String custFirstName;

	private String custLastName;

	private String custType;

	private String cityNme;

	private String line1Text;

	private String line2Text;

	private String line3Text;

	private String pincode;

	private String stateNme;

	private String custPhn;

	private String custEmail;

	private String panNbr;

	private String gstin;

	private boolean syntacticallyValid;

	private boolean functionallyValid;

	public Customer() {
	}

	/**
	 * @param customerId
	 * @param custCategory
	 * @param custComment
	 * @param custFirstName
	 * @param custLastName
	 * @param custType
	 * @param cityNme
	 * @param line1Text
	 * @param line2Text
	 * @param line3Text
	 * @param pincode
	 * @param stateNme
	 * @param custPhn
	 * @param custEmail
	 * @param panNbr
	 * @param gstin
	 */
	public Customer(int customerId, String custCategory, String custComment, String custFirstName, String custLastName,
			String custType, String cityNme, String line1Text, String line2Text, String line3Text, String pincode,
			String stateNme, String custPhn, String custEmail, String panNbr, String gstin) {
		this.customerId = customerId;
		this.custCategory = custCategory;
		this.custComment = custComment;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custType = custType;
		this.cityNme = cityNme;
		this.line1Text = line1Text;
		this.line2Text = line2Text;
		this.line3Text = line3Text;
		this.pincode = pincode;
		this.stateNme = stateNme;
		this.custPhn = custPhn;
		this.custEmail = custEmail;
		this.panNbr = panNbr;
		this.gstin = gstin;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the custCategory
	 */
	public String getCustCategory() {
		return custCategory;
	}

	/**
	 * @param custCategory
	 *            the custCategory to set
	 */
	public void setCustCategory(String custCategory) {
		this.custCategory = custCategory;
	}

	/**
	 * @return the custComment
	 */
	public String getCustComment() {
		return custComment;
	}

	/**
	 * @param custComment
	 *            the custComment to set
	 */
	public void setCustComment(String custComment) {
		this.custComment = custComment;
	}

	/**
	 * @return the custFirstName
	 */
	public String getCustFirstName() {
		return custFirstName;
	}

	/**
	 * @param custFirstName
	 *            the custFirstName to set
	 */
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	/**
	 * @return the custLastName
	 */
	public String getCustLastName() {
		return custLastName;
	}

	/**
	 * @param custLastName
	 *            the custLastName to set
	 */
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	/**
	 * @return the custType
	 */
	public String getCustType() {
		return custType;
	}

	/**
	 * @param custType
	 *            the custType to set
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}

	/**
	 * @return the cityNme
	 */
	public String getCityNme() {
		return cityNme;
	}

	/**
	 * @param cityNme
	 *            the cityNme to set
	 */
	public void setCityNme(String cityNme) {
		this.cityNme = cityNme;
	}

	/**
	 * @return the line1Text
	 */
	public String getLine1Text() {
		return line1Text;
	}

	/**
	 * @param line1Text
	 *            the line1Text to set
	 */
	public void setLine1Text(String line1Text) {
		this.line1Text = line1Text;
	}

	/**
	 * @return the line2Text
	 */
	public String getLine2Text() {
		return line2Text;
	}

	/**
	 * @param line2Text
	 *            the line2Text to set
	 */
	public void setLine2Text(String line2Text) {
		this.line2Text = line2Text;
	}

	/**
	 * @return the line3Text
	 */
	public String getLine3Text() {
		return line3Text;
	}

	/**
	 * @param line3Text
	 *            the line3Text to set
	 */
	public void setLine3Text(String line3Text) {
		this.line3Text = line3Text;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the stateNme
	 */
	public String getStateNme() {
		return stateNme;
	}

	/**
	 * @param stateNme
	 *            the stateNme to set
	 */
	public void setStateNme(String stateNme) {
		this.stateNme = stateNme;
	}

	/**
	 * @return the custPhn
	 */
	public String getCustPhn() {
		return custPhn;
	}

	/**
	 * @param custPhn
	 *            the custPhn to set
	 */
	public void setCustPhn(String custPhn) {
		this.custPhn = custPhn;
	}

	/**
	 * @return the custEmail
	 */
	public String getCustEmail() {
		return custEmail;
	}

	/**
	 * @param custEmail
	 *            the custEmail to set
	 */
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	/**
	 * @return the panNbr
	 */
	public String getPanNbr() {
		return panNbr;
	}

	/**
	 * @param panNbr
	 *            the panNbr to set
	 */
	public void setPanNbr(String panNbr) {
		this.panNbr = panNbr;
	}

	/**
	 * @return the gstin
	 */
	public String getGstin() {
		return gstin;
	}

	/**
	 * @param gstin
	 *            the gstin to set
	 */
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	/**
	 * @return the syntacticallyValid
	 */
	public boolean isSyntacticallyValid() {
		return syntacticallyValid;
	}

	/**
	 * @param syntacticallyValid
	 *            the syntacticallyValid to set
	 */
	public void setSyntacticallyValid(boolean syntacticallyValid) {
		this.syntacticallyValid = syntacticallyValid;
	}

	/**
	 * @return the functionallyValid
	 */
	public boolean isFunctionallyValid() {
		return functionallyValid;
	}

	/**
	 * @param functionallyValid
	 *            the functionallyValid to set
	 */
	public void setFunctionallyValid(boolean functionallyValid) {
		this.functionallyValid = functionallyValid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityNme == null) ? 0 : cityNme.hashCode());
		result = prime * result + ((custCategory == null) ? 0 : custCategory.hashCode());
		result = prime * result + ((custComment == null) ? 0 : custComment.hashCode());
		result = prime * result + ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + ((custFirstName == null) ? 0 : custFirstName.hashCode());
		result = prime * result + ((custLastName == null) ? 0 : custLastName.hashCode());
		result = prime * result + ((custPhn == null) ? 0 : custPhn.hashCode());
		result = prime * result + ((custType == null) ? 0 : custType.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((gstin == null) ? 0 : gstin.hashCode());
		result = prime * result + ((line1Text == null) ? 0 : line1Text.hashCode());
		result = prime * result + ((line2Text == null) ? 0 : line2Text.hashCode());
		result = prime * result + ((line3Text == null) ? 0 : line3Text.hashCode());
		result = prime * result + ((panNbr == null) ? 0 : panNbr.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((stateNme == null) ? 0 : stateNme.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		if (cityNme == null) {
			if (other.cityNme != null) {
				return false;
			}
		} else if (!cityNme.equals(other.cityNme)) {
			return false;
		}
		if (custCategory == null) {
			if (other.custCategory != null) {
				return false;
			}
		} else if (!custCategory.equals(other.custCategory)) {
			return false;
		}
		if (custComment == null) {
			if (other.custComment != null) {
				return false;
			}
		} else if (!custComment.equals(other.custComment)) {
			return false;
		}
		if (custEmail == null) {
			if (other.custEmail != null) {
				return false;
			}
		} else if (!custEmail.equals(other.custEmail)) {
			return false;
		}
		if (custFirstName == null) {
			if (other.custFirstName != null) {
				return false;
			}
		} else if (!custFirstName.equals(other.custFirstName)) {
			return false;
		}
		if (custLastName == null) {
			if (other.custLastName != null) {
				return false;
			}
		} else if (!custLastName.equals(other.custLastName)) {
			return false;
		}
		if (custPhn == null) {
			if (other.custPhn != null) {
				return false;
			}
		} else if (!custPhn.equals(other.custPhn)) {
			return false;
		}
		if (custType == null) {
			if (other.custType != null) {
				return false;
			}
		} else if (!custType.equals(other.custType)) {
			return false;
		}
		if (customerId != other.customerId) {
			return false;
		}
		if (gstin == null) {
			if (other.gstin != null) {
				return false;
			}
		} else if (!gstin.equals(other.gstin)) {
			return false;
		}
		if (line1Text == null) {
			if (other.line1Text != null) {
				return false;
			}
		} else if (!line1Text.equals(other.line1Text)) {
			return false;
		}
		if (line2Text == null) {
			if (other.line2Text != null) {
				return false;
			}
		} else if (!line2Text.equals(other.line2Text)) {
			return false;
		}
		if (line3Text == null) {
			if (other.line3Text != null) {
				return false;
			}
		} else if (!line3Text.equals(other.line3Text)) {
			return false;
		}
		if (panNbr == null) {
			if (other.panNbr != null) {
				return false;
			}
		} else if (!panNbr.equals(other.panNbr)) {
			return false;
		}
		if (pincode == null) {
			if (other.pincode != null) {
				return false;
			}
		} else if (!pincode.equals(other.pincode)) {
			return false;
		}
		if (stateNme == null) {
			if (other.stateNme != null) {
				return false;
			}
		} else if (!stateNme.equals(other.stateNme)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerId=").append(customerId).append(", ");
		if (custCategory != null)
			builder.append("custCategory=").append(custCategory).append(", ");
		if (custComment != null)
			builder.append("custComment=").append(custComment).append(", ");
		if (custFirstName != null)
			builder.append("custFirstName=").append(custFirstName).append(", ");
		if (custLastName != null)
			builder.append("custLastName=").append(custLastName).append(", ");
		if (custType != null)
			builder.append("custType=").append(custType).append(", ");
		if (cityNme != null)
			builder.append("cityNme=").append(cityNme).append(", ");
		if (line1Text != null)
			builder.append("line1Text=").append(line1Text).append(", ");
		if (line2Text != null)
			builder.append("line2Text=").append(line2Text).append(", ");
		if (line3Text != null)
			builder.append("line3Text=").append(line3Text).append(", ");
		if (pincode != null)
			builder.append("pincode=").append(pincode).append(", ");
		if (stateNme != null)
			builder.append("stateNme=").append(stateNme).append(", ");
		if (custPhn != null)
			builder.append("custPhn=").append(custPhn).append(", ");
		if (custEmail != null)
			builder.append("custEmail=").append(custEmail).append(", ");
		if (panNbr != null)
			builder.append("panNbr=").append(panNbr).append(", ");
		if (gstin != null)
			builder.append("gstin=").append(gstin);
		builder.append("]");
		return builder.toString();
	}

}