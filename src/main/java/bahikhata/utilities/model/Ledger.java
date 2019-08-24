/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Vrinda This is a model class for the LEDGER database table.
 * 
 */

public class Ledger implements Serializable {
	private static final long serialVersionUID = 1L;

	private int sequenceNumber;

	// bi-directional many-to-one association to Journal
	private Journal journalTransactionNumber;

	// bi-directional many-to-one association to Account
	private Account debitedAccount;

	// bi-directional many-to-one association to Account
	private Account creditedAccount;

	private BigDecimal creditAmount;

	private BigDecimal debitAmount;

	// bi-directional many-to-one association to Account
	private Account ledgerAccount;

	public Ledger() {
	}

	/**
	 * @param sequenceNumber
	 * @param journalTransactionNumber
	 * @param debitedAccount
	 * @param creditedAccount
	 * @param creditAmount
	 * @param debitAmount
	 * @param ledgerAccount
	 */
	public Ledger(int sequenceNumber, Journal journalTransactionNumber, Account debitedAccount, Account creditedAccount,
			BigDecimal creditAmount, BigDecimal debitAmount, Account ledgerAccount) {
		this.sequenceNumber = sequenceNumber;
		this.journalTransactionNumber = journalTransactionNumber;
		this.debitedAccount = debitedAccount;
		this.creditedAccount = creditedAccount;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.ledgerAccount = ledgerAccount;
	}

	/**
	 * @return the sequenceNumber
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * @param sequenceNumber the sequenceNumber to set
	 */
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	/**
	 * @return the journalTransactionNumber
	 */
	public Journal getJournalTransactionNumber() {
		return journalTransactionNumber;
	}

	/**
	 * @param journalTransactionNumber the journalTransactionNumber to set
	 */
	public void setJournalTransactionNumber(Journal journalTransactionNumber) {
		this.journalTransactionNumber = journalTransactionNumber;
	}

	/**
	 * @return the debitedAccount
	 */
	public Account getDebitedAccount() {
		return debitedAccount;
	}

	/**
	 * @param debitedAccount the debitedAccount to set
	 */
	public void setDebitedAccount(Account debitedAccount) {
		this.debitedAccount = debitedAccount;
	}

	/**
	 * @return the creditedAccount
	 */
	public Account getCreditedAccount() {
		return creditedAccount;
	}

	/**
	 * @param creditedAccount the creditedAccount to set
	 */
	public void setCreditedAccount(Account creditedAccount) {
		this.creditedAccount = creditedAccount;
	}

	/**
	 * @return the creditAmount
	 */
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	/**
	 * @param creditAmount the creditAmount to set
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
	 * @param debitAmount the debitAmount to set
	 */
	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	/**
	 * @return the ledgerAccount
	 */
	public Account getLedgerAccount() {
		return ledgerAccount;
	}

	/**
	 * @param ledgerAccount the ledgerAccount to set
	 */
	public void setLedgerAccount(Account ledgerAccount) {
		this.ledgerAccount = ledgerAccount;
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
		result = prime * result + ((creditAmount == null) ? 0 : creditAmount.hashCode());
		result = prime * result + ((creditedAccount == null) ? 0 : creditedAccount.hashCode());
		result = prime * result + ((debitAmount == null) ? 0 : debitAmount.hashCode());
		result = prime * result + ((debitedAccount == null) ? 0 : debitedAccount.hashCode());
		result = prime * result + ((journalTransactionNumber == null) ? 0 : journalTransactionNumber.hashCode());
		result = prime * result + ((ledgerAccount == null) ? 0 : ledgerAccount.hashCode());
		result = prime * result + sequenceNumber;
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
		if (!(obj instanceof Ledger)) {
			return false;
		}
		Ledger other = (Ledger) obj;
		if (creditAmount == null) {
			if (other.creditAmount != null) {
				return false;
			}
		} else if (!creditAmount.equals(other.creditAmount)) {
			return false;
		}
		if (creditedAccount == null) {
			if (other.creditedAccount != null) {
				return false;
			}
		} else if (!creditedAccount.equals(other.creditedAccount)) {
			return false;
		}
		if (debitAmount == null) {
			if (other.debitAmount != null) {
				return false;
			}
		} else if (!debitAmount.equals(other.debitAmount)) {
			return false;
		}
		if (debitedAccount == null) {
			if (other.debitedAccount != null) {
				return false;
			}
		} else if (!debitedAccount.equals(other.debitedAccount)) {
			return false;
		}
		if (journalTransactionNumber == null) {
			if (other.journalTransactionNumber != null) {
				return false;
			}
		} else if (!journalTransactionNumber.equals(other.journalTransactionNumber)) {
			return false;
		}
		if (ledgerAccount == null) {
			if (other.ledgerAccount != null) {
				return false;
			}
		} else if (!ledgerAccount.equals(other.ledgerAccount)) {
			return false;
		}
		if (sequenceNumber != other.sequenceNumber) {
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
		builder.append("Ledger [sequenceNumber=").append(sequenceNumber).append(", ");
		if (journalTransactionNumber != null)
			builder.append("journalTransactionNumber=").append(journalTransactionNumber).append(", ");
		if (debitedAccount != null)
			builder.append("debitedAccount=").append(debitedAccount).append(", ");
		if (creditedAccount != null)
			builder.append("creditedAccount=").append(creditedAccount).append(", ");
		if (creditAmount != null)
			builder.append("creditAmount=").append(creditAmount).append(", ");
		if (debitAmount != null)
			builder.append("debitAmount=").append(debitAmount).append(", ");
		if (ledgerAccount != null)
			builder.append("ledgerAccount=").append(ledgerAccount);
		builder.append("]");
		return builder.toString();
	}

}