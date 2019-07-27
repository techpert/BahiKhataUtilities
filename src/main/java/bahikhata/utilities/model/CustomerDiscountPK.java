/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */

package bahikhata.utilities.model;

import java.io.Serializable;

/**
 * This is a model class for CUSTOMER_DISCOUNT PK.
 * 
 * @author Surbhi Gupta
 */
public class CustomerDiscountPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int itemId;

	private String custType;

	public CustomerDiscountPK() {
	}

	/**
	 * @param itemId
	 * @param custType
	 */
	public CustomerDiscountPK(int itemId, String custType) {
		this.itemId = itemId;
		this.custType = custType;
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custType == null) ? 0 : custType.hashCode());
		result = prime * result + itemId;
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
		if (!(obj instanceof CustomerDiscountPK)) {
			return false;
		}
		CustomerDiscountPK other = (CustomerDiscountPK) obj;
		if (custType == null) {
			if (other.custType != null) {
				return false;
			}
		} else if (!custType.equals(other.custType)) {
			return false;
		}
		if (itemId != other.itemId) {
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
		builder.append("CustomerDiscountPK [itemId=").append(itemId).append(", ");
		if (custType != null)
			builder.append("custType=").append(custType);
		builder.append("]");
		return builder.toString();
	}

}