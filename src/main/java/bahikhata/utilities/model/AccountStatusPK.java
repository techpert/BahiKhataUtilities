/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Vrinda This is the primary key class for the ACCOUNT_STATUS database
 *         table.
 * 
 */
public class AccountStatusPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String accountName;

	private LocalDate businessDay;

	public AccountStatusPK() {
	}

	/**
	 * @param accountName
	 * @param businessDay
	 */
	public AccountStatusPK(String accountName, LocalDate businessDay) {
		this.accountName = accountName;
		this.businessDay = businessDay;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the businessDay
	 */
	public LocalDate getBusinessDay() {
		return businessDay;
	}

	/**
	 * @param businessDay the businessDay to set
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
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((businessDay == null) ? 0 : businessDay.hashCode());
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
		if (!(obj instanceof AccountStatusPK)) {
			return false;
		}
		AccountStatusPK other = (AccountStatusPK) obj;
		if (accountName == null) {
			if (other.accountName != null) {
				return false;
			}
		} else if (!accountName.equals(other.accountName)) {
			return false;
		}
		if (businessDay == null) {
			if (other.businessDay != null) {
				return false;
			}
		} else if (!businessDay.equals(other.businessDay)) {
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
		builder.append("AccountStatusPK [");
		if (accountName != null)
			builder.append("accountName=").append(accountName).append(", ");
		if (businessDay != null)
			builder.append("businessDay=").append(businessDay);
		builder.append("]");
		return builder.toString();
	}

}