package com.che.transfer;

import com.che.controllers.AccountController;
import com.che.controllers.CustomerController;
import com.che.exceptions.*;
import com.che.models.customer.Customer;
import com.che.models.payment.PaypalTransfer;

public class PaypalPaymentImpl implements Payment {

	private PaypalTransfer    paypalTransfer;
	private AccountController accountController;

	public PaypalPaymentImpl(PaypalTransfer paypalTransfer) {
		this.paypalTransfer = paypalTransfer;
		this.accountController = new AccountController();
	}

	@Override public void transferMoney() throws UnsuccessfulPaymentException {
		try {
			// Paypal api usage comes here
			accountController.withdrawMoney(paypalTransfer.getDebitAccount(), paypalTransfer.getAmount());
			System.out.println("##Paypal transaction has been completed");
		} catch (Throwable t) {
			throw new UnsuccessfulPaymentException(t.getMessage(), t);
		}
	}

	@Override public void validateBeforeTransaction()
			throws NotAvailableAccountBalanceException,
			NoSuchCustomerException,
			NoSuchAccountException,
			InvalidEmailException
	{
		//Account validation
		accountController.validateAccount(paypalTransfer.getDebitAccount());

		//Customer validation
		Customer customer = CustomerController.getCustomer(paypalTransfer.getDebitAccount().getCustomerNumber());
		accountController.validateEmail(customer.getEmail());

		//balance check
		accountController.debitAccountBalanceCheck(paypalTransfer.getDebitAccount(), paypalTransfer.getAmount());
	}
}
