/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author Vrinda This is a model class for the TILL database table.
 * 
 */
public class Till implements Serializable {
	private static final long serialVersionUID = 1L;

	private TillPK id;

	private ZonedDateTime openingDateTime;

	private ZonedDateTime closingDateTime;

	private BigDecimal tillOpeningAmount;

	private BigDecimal tillClosingAmount;

	private BigDecimal tillOverShort;

	private String overShortFlag;

	public Till() {
	}

	/**
	 * @param id
	 * @param openingDateTime
	 * @param closingDateTime
	 * @param tillOpeningAmount
	 * @param tillClosingAmount
	 * @param tillOverShort
	 * @param overShortFlag
	 */
	public Till(TillPK id, ZonedDateTime openingDateTime, ZonedDateTime closingDateTime, BigDecimal tillOpeningAmount,
			BigDecimal tillClosingAmount, BigDecimal tillOverShort, String overShortFlag) {
		this.id = id;
		this.openingDateTime = openingDateTime;
		this.closingDateTime = closingDateTime;
		this.tillOpeningAmount = tillOpeningAmount;
		this.tillClosingAmount = tillClosingAmount;
		this.tillOverShort = tillOverShort;
		this.overShortFlag = overShortFlag;
	}

	/**
	 * @return the id
	 */
	public TillPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TillPK id) {
		this.id = id;
	}

	/**
	 * @return the openingDateTime
	 */
	public ZonedDateTime getOpeningDateTime() {
		return openingDateTime;
	}

	/**
	 * @param openingDateTime the openingDateTime to set
	 */
	public void setOpeningDateTime(ZonedDateTime openingDateTime) {
		this.openingDateTime = openingDateTime;
	}

	/**
	 * @return the closingDateTime
	 */
	public ZonedDateTime getClosingDateTime() {
		return closingDateTime;
	}

	/**
	 * @param closingDateTime the closingDateTime to set
	 */
	public void setClosingDateTime(ZonedDateTime closingDateTime) {
		this.closingDateTime = closingDateTime;
	}

	/**
	 * @return the tillOpeningAmount
	 */
	public BigDecimal getTillOpeningAmount() {
		return tillOpeningAmount;
	}

	/**
	 * @param tillOpeningAmount the tillOpeningAmount to set
	 */
	public void setTillOpeningAmount(BigDecimal tillOpeningAmount) {
		this.tillOpeningAmount = tillOpeningAmount;
	}

	/**
	 * @return the tillClosingAmount
	 */
	public BigDecimal getTillClosingAmount() {
		return tillClosingAmount;
	}

	/**
	 * @param tillClosingAmount the tillClosingAmount to set
	 */
	public void setTillClosingAmount(BigDecimal tillClosingAmount) {
		this.tillClosingAmount = tillClosingAmount;
	}

	/**
	 * @return the tillOverShort
	 */
	public BigDecimal getTillOverShort() {
		return tillOverShort;
	}

	/**
	 * @param tillOverShort the tillOverShort to set
	 */
	public void setTillOverShort(BigDecimal tillOverShort) {
		this.tillOverShort = tillOverShort;
	}

	/**
	 * @return the overShortFlag
	 */
	public String getOverShortFlag() {
		return overShortFlag;
	}

	/**
	 * @param overShortFlag the overShortFlag to set
	 */
	public void setOverShortFlag(String overShortFlag) {
		this.overShortFlag = overShortFlag;
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
		result = prime * result + ((closingDateTime == null) ? 0 : closingDateTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((openingDateTime == null) ? 0 : openingDateTime.hashCode());
		result = prime * result + ((overShortFlag == null) ? 0 : overShortFlag.hashCode());
		result = prime * result + ((tillClosingAmount == null) ? 0 : tillClosingAmount.hashCode());
		result = prime * result + ((tillOpeningAmount == null) ? 0 : tillOpeningAmount.hashCode());
		result = prime * result + ((tillOverShort == null) ? 0 : tillOverShort.hashCode());
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
		if (!(obj instanceof Till)) {
			return false;
		}
		Till other = (Till) obj;
		if (closingDateTime == null) {
			if (other.closingDateTime != null) {
				return false;
			}
		} else if (!closingDateTime.equals(other.closingDateTime)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (openingDateTime == null) {
			if (other.openingDateTime != null) {
				return false;
			}
		} else if (!openingDateTime.equals(other.openingDateTime)) {
			return false;
		}
		if (overShortFlag == null) {
			if (other.overShortFlag != null) {
				return false;
			}
		} else if (!overShortFlag.equals(other.overShortFlag)) {
			return false;
		}
		if (tillClosingAmount == null) {
			if (other.tillClosingAmount != null) {
				return false;
			}
		} else if (!tillClosingAmount.equals(other.tillClosingAmount)) {
			return false;
		}
		if (tillOpeningAmount == null) {
			if (other.tillOpeningAmount != null) {
				return false;
			}
		} else if (!tillOpeningAmount.equals(other.tillOpeningAmount)) {
			return false;
		}
		if (tillOverShort == null) {
			if (other.tillOverShort != null) {
				return false;
			}
		} else if (!tillOverShort.equals(other.tillOverShort)) {
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
		builder.append("Till [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (openingDateTime != null)
			builder.append("openingDateTime=").append(openingDateTime).append(", ");
		if (closingDateTime != null)
			builder.append("closingDateTime=").append(closingDateTime).append(", ");
		if (tillOpeningAmount != null)
			builder.append("tillOpeningAmount=").append(tillOpeningAmount).append(", ");
		if (tillClosingAmount != null)
			builder.append("tillClosingAmount=").append(tillClosingAmount).append(", ");
		if (tillOverShort != null)
			builder.append("tillOverShort=").append(tillOverShort).append(", ");
		if (overShortFlag != null)
			builder.append("overShortFlag=").append(overShortFlag);
		builder.append("]");
		return builder.toString();
	}

}