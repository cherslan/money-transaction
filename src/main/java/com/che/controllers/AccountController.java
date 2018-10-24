package com.che.controllers;

import com.che.exceptions.*;
import com.che.models.account.Account;
import com.che.models.customer.Customer;

import java.util.regex.Pattern;

public class AccountController {

	private static final String EMAIL_REGEX_VALIDATOR = "(.*?)";

	public Account validateAccount(Account acct) throws NoSuchAccountException {
		Customer customer = CustomerController.getCustomer(acct.getCustomerNumber());
		Account account = customer.getAccounts().stream()
				.filter(filter -> filter.getAccountNumber().equals(acct.getAccountNumber()))
				.findFirst().orElse(null);
		if (account == null) {
			throw new NoSuchAccountException();
		}

		return account;
	}

	public void debitAccountBalanceCheck(Account debitAccount, double amount) throws NotAvailableAccountBalanceException {
		if (debitAccount.getBalance() < amount) {
			throw new NotAvailableAccountBalanceException();
		}
	}

	public void validateIbanNumber(String ibanNumber) throws InvalidIbanNumberException {
		System.out.println("(validateIbanNumber) - Not implemented since this is only demonstration!");
	}

	public void validateEmail(String email) throws InvalidEmailException {
		if (!Pattern.matches(EMAIL_REGEX_VALIDATOR, email)) {
			throw new InvalidEmailException();
		}
	}

	public synchronized void withdrawMoney(Account account, double amount) throws UnsuccessfulPaymentException {
		try {
			System.out.println("=========== Withdrawing Money ============");
			System.out.println(account.getAccountNumber()  + ", balance before transaction: " + account.getBalance());
			account.setBalance(account.getBalance() - amount);
			CustomerController.saveDummyCustomers();
			System.out.println(account.getAccountNumber()  + ", balance after transaction: " + account.getBalance());
		} catch (Throwable t) {
			throw new UnsuccessfulPaymentException(t.getMessage(), t);
		}
	}

	public synchronized void depositMoney(Account account, double amount) throws UnsuccessfulPaymentException {
		try {
			System.out.println("=========== Deposit Money ============");
			System.out.println(account.getAccountNumber()  + ", balance before transaction: " + account.getBalance());
			account.setBalance(account.getBalance() + amount);
			CustomerController.saveDummyCustomers();
			System.out.println(account.getAccountNumber()  + ", balance after transaction: " + account.getBalance());
		} catch (Throwable t) {
			throw new UnsuccessfulPaymentException(t.getMessage(), t);
		}
	}
}
