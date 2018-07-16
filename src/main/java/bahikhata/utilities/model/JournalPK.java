/**
 * copyright © 2018 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Vrinda This is the primary key class for the JOURNAL database table.
 * 
 */
public class JournalPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private LocalDate businessDay;

	private int transactionNumber;

	public JournalPK() {
	}

	/**
	 * @param businessDay
	 * @param transactionNumber
	 */
	public JournalPK(LocalDate businessDay, int transactionNumber) {
		this.businessDay = businessDay;
		this.transactionNumber = transactionNumber;
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

	/**
	 * @return the transactionNumber
	 */
	public int getTransactionNumber() {
		return transactionNumber;
	}

	/**
	 * @param transactionNumber
	 *            the transactionNumber to set
	 */
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
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
		result = prime * result + transactionNumber;
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
		if (!(obj instanceof JournalPK)) {
			return false;
		}
		JournalPK other = (JournalPK) obj;
		if (businessDay == null) {
			if (other.businessDay != null) {
				return false;
			}
		} else if (!businessDay.equals(other.businessDay)) {
			return false;
		}
		if (transactionNumber != other.transactionNumber) {
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
		builder.append("JournalPK [");
		if (businessDay != null)
			builder.append("businessDay=").append(businessDay).append(", ");
		builder.append("transactionNumber=").append(transactionNumber).append("]");
		return builder.toString();
	}

}