/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */

package bahikhata.utilities.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * This is a model class for ITEM_QUP_DISCOUNT database table.
 * 
 * @author Surbhi Gupta
 */
public class ItemQupDiscount implements Serializable {
	private static final long serialVersionUID = 1L;

	private ItemQupDiscountPK id;

	private BigDecimal discPrcnt;

	public ItemQupDiscount() {
	}

	/**
	 * @param id
	 * @param discPrcnt
	 */
	public ItemQupDiscount(ItemQupDiscountPK id, BigDecimal discPrcnt) {
		this.id = id;
		this.discPrcnt = discPrcnt;
	}

	/**
	 * @return the id
	 */
	public ItemQupDiscountPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ItemQupDiscountPK id) {
		this.id = id;
	}

	/**
	 * @return the discPrcnt
	 */
	public BigDecimal getDiscPrcnt() {
		return discPrcnt;
	}

	/**
	 * @param discPrcnt the discPrcnt to set
	 */
	public void setDiscPrcnt(BigDecimal discPrcnt) {
		this.discPrcnt = discPrcnt;
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
		result = prime * result + ((discPrcnt == null) ? 0 : discPrcnt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!(obj instanceof ItemQupDiscount)) {
			return false;
		}
		ItemQupDiscount other = (ItemQupDiscount) obj;
		if (discPrcnt == null) {
			if (other.discPrcnt != null) {
				return false;
			}
		} else if (!discPrcnt.equals(other.discPrcnt)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
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
		builder.append("ItemQupDiscount [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (discPrcnt != null)
			builder.append("discPrcnt=").append(discPrcnt);
		builder.append("]");
		return builder.toString();
	}

}