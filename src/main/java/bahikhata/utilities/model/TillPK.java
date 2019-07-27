/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Vrinda This is the primary key class for the TILL database table.
 * 
 */
public class TillPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int till_Id;

	private LocalDate businessDay;

	public TillPK() {
	}

	/**
	 * @param till_Id
	 * @param businessDay
	 */
	public TillPK(int till_Id, LocalDate businessDay) {
		this.till_Id = till_Id;
		this.businessDay = businessDay;
	}

	/**
	 * @return the till_Id
	 */
	public int getTill_Id() {
		return till_Id;
	}

	/**
	 * @param till_Id
	 *            the till_Id to set
	 */
	public void setTill_Id(int till_Id) {
		this.till_Id = till_Id;
	}

	/**
	 * @return the businessDay
	 */
	public LocalDate getBusinessDay() {
		return businessDay;
	}

	/**
	 * @param businessDay
	 *            the businessDay to set
	 */
	public void setBusinessDay(LocalDate businessDay) {
		this.businessDay = businessDay;
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
		result = prime * result + ((businessDay == null) ? 0 : businessDay.hashCode());
		result = prime * result + till_Id;
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
		if (!(obj instanceof TillPK)) {
			return false;
		}
		TillPK other = (TillPK) obj;
		if (businessDay == null) {
			if (other.businessDay != null) {
				return false;
			}
		} else if (!businessDay.equals(other.businessDay)) {
			return false;
		}
		if (till_Id != other.till_Id) {
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
		builder.append("TillPK [till_Id=").append(till_Id).append(", ");
		if (businessDay != null)
			builder.append("businessDay=").append(businessDay);
		builder.append("]");
		return builder.toString();
	}

}