/**
 * copyright © 2018 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Vrinda This is a model class for the ACCOUNT database table.
 * 
 */
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private int accountNumber;

	private String accountName;

	private String balanceSheetType;

	private LocalDate dateAdded;

	private String operator;

	private String profitAndLossType;

	// bi-directional many-to-one association to AccountStatus
	private List<AccountStatus> accountStatuses;

	// bi-directional many-to-one association to BalanceSheet
	private List<BalanceSheet> balanceSheetAccount;

	// bi-directional many-to-one association to Journal
	private List<Journal> creditJournal;

	// bi-directional many-to-one association to Journal
	private List<Journal> debitJournal;

	// bi-directional many-to-one association to Ledger
	private List<Ledger> debitLedger;

	// bi-directional many-to-one association to Ledger
	private List<Ledger> creditLedger;

	// bi-directional many-to-one association to Ledger
	private List<Ledger> ledgerAccount;

	// bi-directional many-to-one association to ProfitAndLoss
	private List<ProfitAndLoss> profitAndLossAccount;

	public Account() {
	}

	/**
	 * @param accountNumber
	 * @param accountName
	 * @param balanceSheetType
	 * @param dateAdded
	 * @param operator
	 * @param profitAndLossType
	 * @param accountStatuses
	 * @param balanceSheetAccount
	 * @param creditJournal
	 * @param debitJournal
	 * @param debitLedger
	 * @param creditLedger
	 * @param ledgerAccount
	 * @param profitAndLossAccount
	 */
	public Account(int accountNumber, String accountName, String balanceSheetType, LocalDate dateAdded, String operator,
			String profitAndLossType, List<AccountStatus> accountStatuses, List<BalanceSheet> balanceSheetAccount,
			List<Journal> creditJournal, List<Journal> debitJournal, List<Ledger> debitLedger,
			List<Ledger> creditLedger, List<Ledger> ledgerAccount, List<ProfitAndLoss> profitAndLossAccount) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balanceSheetType = balanceSheetType;
		this.dateAdded = dateAdded;
		this.operator = operator;
		this.profitAndLossType = profitAndLossType;
		this.accountStatuses = accountStatuses;
		this.balanceSheetAccount = balanceSheetAccount;
		this.creditJournal = creditJournal;
		this.debitJournal = debitJournal;
		this.debitLedger = debitLedger;
		this.creditLedger = creditLedger;
		this.ledgerAccount = ledgerAccount;
		this.profitAndLossAccount = profitAndLossAccount;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName
	 *            the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the balanceSheetType
	 */
	public String getBalanceSheetType() {
		return balanceSheetType;
	}

	/**
	 * @param balanceSheetType
	 *            the balanceSheetType to set
	 */
	public void setBalanceSheetType(String balanceSheetType) {
		this.balanceSheetType = balanceSheetType;
	}

	/**
	 * @return the dateAdded
	 */
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded
	 *            the dateAdded to set
	 */
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the profitAndLossType
	 */
	public String getProfitAndLossType() {
		return profitAndLossType;
	}

	/**
	 * @param profitAndLossType
	 *            the profitAndLossType to set
	 */
	public void setProfitAndLossType(String profitAndLossType) {
		this.profitAndLossType = profitAndLossType;
	}

	/**
	 * @return the accountStatuses
	 */
	public List<AccountStatus> getAccountStatuses() {
		return accountStatuses;
	}

	/**
	 * @param accountStatuses
	 *            the accountStatuses to set
	 */
	public void setAccountStatuses(List<AccountStatus> accountStatuses) {
		this.accountStatuses = accountStatuses;
	}

	/**
	 * @return the balanceSheetAccount
	 */
	public List<BalanceSheet> getBalanceSheetAccount() {
		return balanceSheetAccount;
	}

	/**
	 * @param balanceSheetAccount
	 *            the balanceSheetAccount to set
	 */
	public void setBalanceSheetAccount(List<BalanceSheet> balanceSheetAccount) {
		this.balanceSheetAccount = balanceSheetAccount;
	}

	/**
	 * @return the creditJournal
	 */
	public List<Journal> getCreditJournal() {
		return creditJournal;
	}

	/**
	 * @param creditJournal
	 *            the creditJournal to set
	 */
	public void setCreditJournal(List<Journal> creditJournal) {
		this.creditJournal = creditJournal;
	}

	/**
	 * @return the debitJournal
	 */
	public List<Journal> getDebitJournal() {
		return debitJournal;
	}

	/**
	 * @param debitJournal
	 *            the debitJournal to set
	 */
	public void setDebitJournal(List<Journal> debitJournal) {
		this.debitJournal = debitJournal;
	}

	/**
	 * @return the debitLedger
	 */
	public List<Ledger> getDebitLedger() {
		return debitLedger;
	}

	/**
	 * @param debitLedger
	 *            the debitLedger to set
	 */
	public void setDebitLedger(List<Ledger> debitLedger) {
		this.debitLedger = debitLedger;
	}

	/**
	 * @return the creditLedger
	 */
	public List<Ledger> getCreditLedger() {
		return creditLedger;
	}

	/**
	 * @param creditLedger
	 *            the creditLedger to set
	 */
	public void setCreditLedger(List<Ledger> creditLedger) {
		this.creditLedger = creditLedger;
	}

	/**
	 * @return the ledgerAccount
	 */
	public List<Ledger> getLedgerAccount() {
		return ledgerAccount;
	}

	/**
	 * @param ledgerAccount
	 *            the ledgerAccount to set
	 */
	public void setLedgerAccount(List<Ledger> ledgerAccount) {
		this.ledgerAccount = ledgerAccount;
	}

	/**
	 * @return the profitAndLossAccount
	 */
	public List<ProfitAndLoss> getProfitAndLossAccount() {
		return profitAndLossAccount;
	}

	/**
	 * @param profitAndLossAccount
	 *            the profitAndLossAccount to set
	 */
	public void setProfitAndLossAccount(List<ProfitAndLoss> profitAndLossAccount) {
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
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + accountNumber;
		result = prime * result + ((accountStatuses == null) ? 0 : accountStatuses.hashCode());
		result = prime * result + ((balanceSheetAccount == null) ? 0 : balanceSheetAccount.hashCode());
		result = prime * result + ((balanceSheetType == null) ? 0 : balanceSheetType.hashCode());
		result = prime * result + ((creditJournal == null) ? 0 : creditJournal.hashCode());
		result = prime * result + ((creditLedger == null) ? 0 : creditLedger.hashCode());
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + ((debitJournal == null) ? 0 : debitJournal.hashCode());
		result = prime * result + ((debitLedger == null) ? 0 : debitLedger.hashCode());
		result = prime * result + ((ledgerAccount == null) ? 0 : ledgerAccount.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
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
		if (!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		if (accountName == null) {
			if (other.accountName != null) {
				return false;
			}
		} else if (!accountName.equals(other.accountName)) {
			return false;
		}
		if (accountNumber != other.accountNumber) {
			return false;
		}
		if (accountStatuses == null) {
			if (other.accountStatuses != null) {
				return false;
			}
		} else if (!accountStatuses.equals(other.accountStatuses)) {
			return false;
		}
		if (balanceSheetAccount == null) {
			if (other.balanceSheetAccount != null) {
				return false;
			}
		} else if (!balanceSheetAccount.equals(other.balanceSheetAccount)) {
			return false;
		}
		if (balanceSheetType == null) {
			if (other.balanceSheetType != null) {
				return false;
			}
		} else if (!balanceSheetType.equals(other.balanceSheetType)) {
			return false;
		}
		if (creditJournal == null) {
			if (other.creditJournal != null) {
				return false;
			}
		} else if (!creditJournal.equals(other.creditJournal)) {
			return false;
		}
		if (creditLedger == null) {
			if (other.creditLedger != null) {
				return false;
			}
		} else if (!creditLedger.equals(other.creditLedger)) {
			return false;
		}
		if (dateAdded == null) {
			if (other.dateAdded != null) {
				return false;
			}
		} else if (!dateAdded.equals(other.dateAdded)) {
			return false;
		}
		if (debitJournal == null) {
			if (other.debitJournal != null) {
				return false;
			}
		} else if (!debitJournal.equals(other.debitJournal)) {
			return false;
		}
		if (debitLedger == null) {
			if (other.debitLedger != null) {
				return false;
			}
		} else if (!debitLedger.equals(other.debitLedger)) {
			return false;
		}
		if (ledgerAccount == null) {
			if (other.ledgerAccount != null) {
				return false;
			}
		} else if (!ledgerAccount.equals(other.ledgerAccount)) {
			return false;
		}
		if (operator == null) {
			if (other.operator != null) {
				return false;
			}
		} else if (!operator.equals(other.operator)) {
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
		builder.append("Account [accountNumber=").append(accountNumber).append(", ");
		if (accountName != null)
			builder.append("accountName=").append(accountName).append(", ");
		if (balanceSheetType != null)
			builder.append("balanceSheetType=").append(balanceSheetType).append(", ");
		if (dateAdded != null)
			builder.append("dateAdded=").append(dateAdded).append(", ");
		if (operator != null)
			builder.append("operator=").append(operator).append(", ");
		if (profitAndLossType != null)
			builder.append("profitAndLossType=").append(profitAndLossType).append(", ");
		if (accountStatuses != null)
			builder.append("accountStatuses=").append(accountStatuses).append(", ");
		if (balanceSheetAccount != null)
			builder.append("balanceSheetAccount=").append(balanceSheetAccount).append(", ");
		if (creditJournal != null)
			builder.append("creditJournal=").append(creditJournal).append(", ");
		if (debitJournal != null)
			builder.append("debitJournal=").append(debitJournal).append(", ");
		if (debitLedger != null)
			builder.append("debitLedger=").append(debitLedger).append(", ");
		if (creditLedger != null)
			builder.append("creditLedger=").append(creditLedger).append(", ");
		if (ledgerAccount != null)
			builder.append("ledgerAccount=").append(ledgerAccount).append(", ");
		if (profitAndLossAccount != null)
			builder.append("profitAndLossAccount=").append(profitAndLossAccount);
		builder.append("]");
		return builder.toString();
	}

}