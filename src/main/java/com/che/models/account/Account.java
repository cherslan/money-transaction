package com.che.models.account;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement(name = "account")
@XmlType(name = "Account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

	@XmlElement(name = "account-number")
	private String accountNumber;

	@XmlElement(name = "account-title")
	private String title;

	@XmlElement(name="customer-number")
	private String customerNumber;

	@XmlElement(name = "currency")
	private String currency;

	@XmlElement(name = "balance")
	private double balance;

	@XmlElement(name = "iban-number")
	private String ibanNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getIbanNumber() {
		return ibanNumber;
	}

	public void setIbanNumber(String ibanNumber) {
		this.ibanNumber = ibanNumber;
	}

	@Override public String toString() {
		return "Account{" +
				"accountNumber='" + accountNumber + '\'' +
				", title='" + title + '\'' +
				", customerNumber='" + customerNumber + '\'' +
				", currency='" + currency + '\'' +
				", balance=" + balance +
				", ibanNumber='" + ibanNumber + '\'' +
				'}';
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Account))
			return false;
		Account account = (Account) o;
		return Double.compare(account.getBalance(), getBalance()) == 0 &&
				Objects.equals(getAccountNumber(), account.getAccountNumber()) &&
				Objects.equals(getTitle(), account.getTitle()) &&
				Objects.equals(getCustomerNumber(), account.getCustomerNumber()) &&
				Objects.equals(getCurrency(), account.getCurrency()) &&
				Objects.equals(getIbanNumber(), account.getIbanNumber());
	}

	@Override public int hashCode() {
		return Objects.hash(getAccountNumber(), getTitle(), getCustomerNumber(), getCurrency(), getBalance(), getIbanNumber());
	}
}
