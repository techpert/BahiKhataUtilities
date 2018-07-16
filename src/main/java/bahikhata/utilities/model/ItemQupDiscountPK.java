/**
 * copyright © 2018 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;

/**
 * This is a model class for ITEM_QUP_DISCOUNT PK.
 * 
 * @author Surbhi Gupta
 */
public class ItemQupDiscountPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer itemId;

	private int itemQty;

	public ItemQupDiscountPK() {
	}

	/**
	 * @param itemId
	 * @param itemQty
	 */
	public ItemQupDiscountPK(Integer itemId, int itemQty) {
		this.itemId = itemId;
		this.itemQty = itemQty;
	}

	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemQty
	 */
	public int getItemQty() {
		return itemQty;
	}

	/**
	 * @param itemQty
	 *            the itemQty to set
	 */
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
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
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + itemQty;
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
		if (!(obj instanceof ItemQupDiscountPK)) {
			return false;
		}
		ItemQupDiscountPK other = (ItemQupDiscountPK) obj;
		if (itemId == null) {
			if (other.itemId != null) {
				return false;
			}
		} else if (!itemId.equals(other.itemId)) {
			return false;
		}
		if (itemQty != other.itemQty) {
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
		builder.append("ItemQupDiscountPK [");
		if (itemId != null)
			builder.append("itemId=").append(itemId).append(", ");
		builder.append("itemQty=").append(itemQty).append("]");
		return builder.toString();
	}

}