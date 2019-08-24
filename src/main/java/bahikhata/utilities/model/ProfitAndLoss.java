/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Vrinda This is a model class for the PROFIT_AND_LOSS database table.
 * 
 */

public class ProfitAndLoss implements Serializable {
	private static final long serialVersionUID = 1L;

	private ProfitAndLossPK id;

	private String profitAndLossType;

	// bi-directional many-to-one association to Account
	private Account profitAndLossAccount;

	private BigDecimal Amount;

	private LocalDate periodEndDay;

	public ProfitAndLoss() {
	}

	/**
	 * @param id
	 * @param profitAndLossType
	 * @param profitAndLossAccount
	 * @param amount
	 * @param periodEndDay
	 */
	public ProfitAndLoss(ProfitAndLossPK id, String profitAndLossType, Account profitAndLossAccount, BigDecimal amount,
			LocalDate periodEndDay) {
		this.id = id;
		this.profitAndLossType = profitAndLossType;
		this.profitAndLossAccount = profitAndLossAccount;
		Amount = amount;
		this.periodEndDay = periodEndDay;
	}

	/**
	 * @return the id
	 */
	public ProfitAndLossPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ProfitAndLossPK id) {
		this.id = id;
	}

	/**
	 * @return the profitAndLossType
	 */
	public String getProfitAndLossType() {
		return profitAndLossType;
	}

	/**
	 * @param profitAndLossType the profitAndLossType to set
	 */
	public void setProfitAndLossType(String profitAndLossType) {
		this.profitAndLossType = profitAndLossType;
	}

	/**
	 * @return the profitAndLossAccount
	 */
	public Account getProfitAndLossAccount() {
		return profitAndLossAccount;
	}

	/**
	 * @param profitAndLossAccount the profitAndLossAccount to set
	 */
	public void setProfitAndLossAccount(Account profitAndLossAccount) {
		this.profitAndLossAccount = profitAndLossAccount;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return Amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}

	/**
	 * @return the periodEndDay
	 */
	public LocalDate getPeriodEndDay() {
		return periodEndDay;
	}

	/**
	 * @param periodEndDay the periodEndDay to set
	 */
	public void setPeriodEndDay(LocalDate periodEndDay) {
		this.periodEndDay = periodEndDay;
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
		result = prime * result + ((Amount == null) ? 0 : Amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((periodEndDay == null) ? 0 : periodEndDay.hashCode());
		result = prime * result + ((profitAndLossAccount == null) ? 0 : profitAndLossAccount.hashCode());
		result = prime * result + ((profitAndLossType == null) ? 0 : profitAndLossType.hashCode());
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
		if (!(obj instanceof ProfitAndLoss)) {
			return false;
		}
		ProfitAndLoss other = (ProfitAndLoss) obj;
		if (Amount == null) {
			if (other.Amount != null) {
				return false;
			}
		} else if (!Amount.equals(other.Amount)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (periodEndDay == null) {
			if (other.periodEndDay != null) {
				return false;
			}
		} else if (!periodEndDay.equals(other.periodEndDay)) {
			return false;
		}
		if (profitAndLossAccount == null) {
			if (other.profitAndLossAccount != null) {
				return false;
			}
		} else if (!profitAndLossAccount.equals(other.profitAndLossAccount)) {
			return false;
		}
		if (profitAndLossType == null) {
			if (other.profitAndLossType != null) {
				return false;
			}
		} else if (!profitAndLossType.equals(other.profitAndLossType)) {
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
		builder.append("ProfitAndLoss [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (profitAndLossType != null)
			builder.append("profitAndLossType=").append(profitAndLossType).append(", ");
		if (profitAndLossAccount != null)
			builder.append("profitAndLossAccount=").append(profitAndLossAccount).append(", ");
		if (Amount != null)
			builder.append("Amount=").append(Amount).append(", ");
		if (periodEndDay != null)
			builder.append("periodEndDay=").append(periodEndDay);
		builder.append("]");
		return builder.toString();
	}

}