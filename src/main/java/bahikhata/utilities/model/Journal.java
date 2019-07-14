/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Vrinda This is a model class for the JOURNAL database table.
 * 
 */
public class Journal implements Serializable {

	private static final long serialVersionUID = 1L;

	private JournalPK id;

	// bi-directional many-to-one association to Account
	private Account accountDebited;
	// bi-directional many-to-one association to Account
	private Account accountCredited;

	private BigDecimal creditAmount;

	private BigDecimal debitAmount;

	// bi-directional many-to-one association to Ledger
	private List<Ledger> transactionNumber;

	public Journal() {
	}

	/**
	 * @param id
	 * @param accountDebited
	 * @param accountCredited
	 * @param creditAmount
	 * @param debitAmount
	 * @param transactionNumber
	 */
	public Journal(JournalPK id, Account accountDebited, Account accountCredited, BigDecimal creditAmount,
			BigDecimal debitAmount, List<Ledger> transactionNumber) {
		this.id = id;
		this.accountDebited = accountDebited;
		this.accountCredited = accountCredited;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.transactionNumber = transactionNumber;
	}

	/**
	 * @return the id
	 */
	public JournalPK getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(JournalPK id) {
		this.id = id;
	}

	/**
	 * @return the accountDebited
	 */
	public Account getAccountDebited() {
		return accountDebited;
	}

	/**
	 * @param accountDebited
	 *            the accountDebited to set
	 */
	public void setAccountDebited(Account accountDebited) {
		this.accountDebited = accountDebited;
	}

	/**
	 * @return the accountCredited
	 */
	public Account getAccountCredited() {
		return accountCredited;
	}

	/**
	 * @param accountCredited
	 *            the accountCredited to set
	 */
	public void setAccountCredited(Account accountCredited) {
		this.accountCredited = accountCredited;
	}

	/**
	 * @return the creditAmount
	 */
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	/**
	 * @param creditAmount
	 *            the creditAmount to set
	 */
	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	/**
	 * @return the debitAmount
	 */
	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	/**
	 * @param debitAmount
	 *            the debitAmount to set
	 */
	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	/**
	 * @return the transactionNumber
	 */
	public List<Ledger> getTransactionNumber() {
		return transactionNumber;
	}

	/**
	 * @param transactionNumber
	 *            the transactionNumber to set
	 */
	public void setTransactionNumber(List<Ledger> transactionNumber) {
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
		result = prime * result + ((accountCredited == null) ? 0 : accountCredited.hashCode());
		result = prime * result + ((accountDebited == null) ? 0 : accountDebited.hashCode());
		result = prime * result + ((creditAmount == null) ? 0 : creditAmount.hashCode());
		result = prime * result + ((debitAmount == null) ? 0 : debitAmount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((transactionNumber == null) ? 0 : transactionNumber.hashCode());
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
		if (!(obj instanceof Journal)) {
			return false;
		}
		Journal other = (Journal) obj;
		if (accountCredited == null) {
			if (other.accountCredited != null) {
				return false;
			}
		} else if (!accountCredited.equals(other.accountCredited)) {
			return false;
		}
		if (accountDebited == null) {
			if (other.accountDebited != null) {
				return false;
			}
		} else if (!accountDebited.equals(other.accountDebited)) {
			return false;
		}
		if (creditAmount == null) {
			if (other.creditAmount != null) {
				return false;
			}
		} else if (!creditAmount.equals(other.creditAmount)) {
			return false;
		}
		if (debitAmount == null) {
			if (other.debitAmount != null) {
				return false;
			}
		} else if (!debitAmount.equals(other.debitAmount)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (transactionNumber == null) {
			if (other.transactionNumber != null) {
				return false;
			}
		} else if (!transactionNumber.equals(other.transactionNumber)) {
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
		builder.append("Journal [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (accountDebited != null)
			builder.append("accountDebited=").append(accountDebited).append(", ");
		if (accountCredited != null)
			builder.append("accountCredited=").append(accountCredited).append(", ");
		if (creditAmount != null)
			builder.append("creditAmount=").append(creditAmount).append(", ");
		if (debitAmount != null)
			builder.append("debitAmount=").append(debitAmount).append(", ");
		if (transactionNumber != null)
			builder.append("transactionNumber=").append(transactionNumber);
		builder.append("]");
		return builder.toString();
	}

}