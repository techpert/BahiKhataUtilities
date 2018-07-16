/**
 * copyright © 2018 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Vrinda This is a model class for the BALANCE_SHEET database table.
 * 
 */
public class BalanceSheet implements Serializable {
	private static final long serialVersionUID = 1L;

	private BalanceSheetPK id;

	private String type;

	// bi-directional many-to-one association to Account
	private Account balanceSheetAccount;

	private BigDecimal Amount;

	private LocalDate periodEndDay;

	public BalanceSheet() {
	}

	/**
	 * @param id
	 * @param type
	 * @param balanceSheetAccount
	 * @param amount
	 * @param periodEndDay
	 */
	public BalanceSheet(BalanceSheetPK id, String type, Account balanceSheetAccount, BigDecimal amount,
			LocalDate periodEndDay) {
		this.id = id;
		this.type = type;
		this.balanceSheetAccount = balanceSheetAccount;
		Amount = amount;
		this.periodEndDay = periodEndDay;
	}

	/**
	 * @return the id
	 */
	public BalanceSheetPK getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BalanceSheetPK id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the balanceSheetAccount
	 */
	public Account getBalanceSheetAccount() {
		return balanceSheetAccount;
	}

	/**
	 * @param balanceSheetAccount
	 *            the balanceSheetAccount to set
	 */
	public void setBalanceSheetAccount(Account balanceSheetAccount) {
		this.balanceSheetAccount = balanceSheetAccount;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return Amount;
	}

	/**
	 * @param amount
	 *            the amount to set
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
	 * @param periodEndDay
	 *            the periodEndDay to set
	 */
	public void setPeriodEndDay(LocalDate periodEndDay) {
		this.periodEndDay = periodEndDay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BalanceSheet [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (type != null)
			builder.append("type=").append(type).append(", ");
		if (balanceSheetAccount != null)
			builder.append("balanceSheetAccount=").append(balanceSheetAccount).append(", ");
		if (Amount != null)
			builder.append("Amount=").append(Amount).append(", ");
		if (periodEndDay != null)
			builder.append("periodEndDay=").append(periodEndDay);
		builder.append("]");
		return builder.toString();
	}

}