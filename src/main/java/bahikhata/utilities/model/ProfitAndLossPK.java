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
public class ProfitAndLossPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private LocalDate periodStartDay;

	private String profitAndLossAccount;

	public ProfitAndLossPK() {
	}

	/**
	 * @param periodStartDay
	 * @param profitAndLossAccount
	 */
	public ProfitAndLossPK(LocalDate periodStartDay, String profitAndLossAccount) {
		this.periodStartDay = periodStartDay;
		this.profitAndLossAccount = profitAndLossAccount;
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
	 * @return the profitAndLossAccount
	 */
	public String getProfitAndLossAccount() {
		return profitAndLossAccount;
	}

	/**
	 * @param profitAndLossAccount
	 *            the profitAndLossAccount to set
	 */
	public void setProfitAndLossAccount(String profitAndLossAccount) {
		this.profitAndLossAccount = profitAndLossAccount;
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
		result = prime * result + ((periodStartDay == null) ? 0 : periodStartDay.hashCode());
		result = prime * result + ((profitAndLossAccount == null) ? 0 : profitAndLossAccount.hashCode());
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
		if (!(obj instanceof ProfitAndLossPK)) {
			return false;
		}
		ProfitAndLossPK other = (ProfitAndLossPK) obj;
		if (periodStartDay == null) {
			if (other.periodStartDay != null) {
				return false;
			}
		} else if (!periodStartDay.equals(other.periodStartDay)) {
			return false;
		}
		if (profitAndLossAccount == null) {
			if (other.profitAndLossAccount != null) {
				return false;
			}
		} else if (!profitAndLossAccount.equals(other.profitAndLossAccount)) {
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
		builder.append("ProfitAndLossPK [");
		if (periodStartDay != null)
			builder.append("periodStartDay=").append(periodStartDay).append(", ");
		if (profitAndLossAccount != null)
			builder.append("profitAndLossAccount=").append(profitAndLossAccount);
		builder.append("]");
		return builder.toString();
	}

}