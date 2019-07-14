/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Vrinda This is the primary key class for the BALANCE_SHEET database
 *         table.
 * 
 */
public class BalanceSheetPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private LocalDate periodStartDay;

	private String balanceSheetAccount;

	public BalanceSheetPK() {
	}

	/**
	 * @param periodStartDay
	 * @param balanceSheetAccount
	 */
	public BalanceSheetPK(LocalDate periodStartDay, String balanceSheetAccount) {
		this.periodStartDay = periodStartDay;
		this.balanceSheetAccount = balanceSheetAccount;
	}

	/**
	 * @return the periodStartDay
	 */
	public LocalDate getPeriodStartDay() {
		return periodStartDay;
	}

	/**
	 * @param periodStartDay
	 *            the periodStartDay to set
	 */
	public void setPeriodStartDay(LocalDate periodStartDay) {
		this.periodStartDay = periodStartDay;
	}

	/**
	 * @return the balanceSheetAccount
	 */
	public String getBalanceSheetAccount() {
		return balanceSheetAccount;
	}

	/**
	 * @param balanceSheetAccount
	 *            the balanceSheetAccount to set
	 */
	public void setBalanceSheetAccount(String balanceSheetAccount) {
		this.balanceSheetAccount = balanceSheetAccount;
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
		result = prime * result + ((balanceSheetAccount == null) ? 0 : balanceSheetAccount.hashCode());
		result = prime * result + ((periodStartDay == null) ? 0 : periodStartDay.hashCode());
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
		if (!(obj instanceof BalanceSheetPK)) {
			return false;
		}
		BalanceSheetPK other = (BalanceSheetPK) obj;
		if (balanceSheetAccount == null) {
			if (other.balanceSheetAccount != null) {
				return false;
			}
		} else if (!balanceSheetAccount.equals(other.balanceSheetAccount)) {
			return false;
		}
		if (periodStartDay == null) {
			if (other.periodStartDay != null) {
				return false;
			}
		} else if (!periodStartDay.equals(other.periodStartDay)) {
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
		builder.append("BalanceSheetPK [");
		if (periodStartDay != null)
			builder.append("periodStartDay=").append(periodStartDay).append(", ");
		if (balanceSheetAccount != null)
			builder.append("balanceSheetAccount=").append(balanceSheetAccount);
		builder.append("]");
		return builder.toString();
	}

}