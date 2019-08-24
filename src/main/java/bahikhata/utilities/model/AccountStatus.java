/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Vrinda This is a model class for the ACCOUNT database table.
 * 
 */
public class AccountStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	private AccountStatusPK id;

	private BigDecimal closingBalance;

	private BigDecimal openingBalance;

	// bi-directional many-to-one association to Account
	// @MapsId(FIELD_ACCOUNT_NAME)
	private Account account;

	public AccountStatus() {
	}

	/**
	 * @param id
	 * @param closingBalance
	 * @param openingBalance
	 * @param account
	 */
	public AccountStatus(AccountStatusPK id, BigDecimal closingBalance, BigDecimal openingBalance, Account account) {
		this.id = id;
		this.closingBalance = closingBalance;
		this.openingBalance = openingBalance;
		this.account = account;
	}

	/**
	 * @return the id
	 */
	public AccountStatusPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(AccountStatusPK id) {
		this.id = id;
	}

	/**
	 * @return the closingBalance
	 */
	public BigDecimal getClosingBalance() {
		return closingBalance;
	}

	/**
	 * @param closingBalance the closingBalance to set
	 */
	public void setClosingBalance(BigDecimal closingBalance) {
		this.closingBalance = closingBalance;
	}

	/**
	 * @return the openingBalance
	 */
	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}

	/**
	 * @param openingBalance the openingBalance to set
	 */
	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
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
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((closingBalance == null) ? 0 : closingBalance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((openingBalance == null) ? 0 : openingBalance.hashCode());
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
		if (!(obj instanceof AccountStatus)) {
			return false;
		}
		AccountStatus other = (AccountStatus) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		if (closingBalance == null) {
			if (other.closingBalance != null) {
				return false;
			}
		} else if (!closingBalance.equals(other.closingBalance)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (openingBalance == null) {
			if (other.openingBalance != null) {
				return false;
			}
		} else if (!openingBalance.equals(other.openingBalance)) {
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
		builder.append("AccountStatus [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (closingBalance != null)
			builder.append("closingBalance=").append(closingBalance).append(", ");
		if (openingBalance != null)
			builder.append("openingBalance=").append(openingBalance).append(", ");
		if (account != null)
			builder.append("account=").append(account);
		builder.append("]");
		return builder.toString();
	}

}