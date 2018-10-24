package com.che.models.payment;

import com.che.models.account.Account;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="PaymentBaseEntity")
@XmlType(name="PaymentBaseEntity")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class PaymentBaseEntity {

	@XmlElement(name="debitAccount")
	private Account debitAccount;

	@XmlElement(name="amount")
	private double amount;

	public Account getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(Account debitAccount) {
		this.debitAccount = debitAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
