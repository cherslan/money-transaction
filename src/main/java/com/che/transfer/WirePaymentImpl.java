package com.che.transfer;

import com.che.controllers.AccountController;
import com.che.exceptions.NoSuchAccountException;
import com.che.exceptions.NoSuchCustomerException;
import com.che.exceptions.NotAvailableAccountBalanceException;
import com.che.exceptions.UnsuccessfulPaymentException;
import com.che.models.payment.WireTransfer;

/**
 * <p>
 * This is implementation should be involved in case money transaction will occur between two internal accounts
 * </p>
 */
public class WirePaymentImpl implements Payment {

	private WireTransfer      wireTransfer;
	private AccountController accountController;

	public WirePaymentImpl(WireTransfer wireTransfer) {
		this.wireTransfer = wireTransfer;
		this.accountController = new AccountController();
	}

	@Override public void transferMoney() throws UnsuccessfulPaymentException {
		try {
			accountController.withdrawMoney(wireTransfer.getDebitAccount(), wireTransfer.getAmount());
			accountController.depositMoney(wireTransfer.getBeneficiaryAccount(), wireTransfer.getAmount());
			System.out.println("##Internal money transaction has been completed");
		} catch (Throwable t) {
			throw new UnsuccessfulPaymentException(t.getMessage(), t);
		}
	}

	@Override public void validateBeforeTransaction()
			throws NotAvailableAccountBalanceException,
			NoSuchCustomerException,
			NoSuchAccountException
	{
		//Account validation
		accountController.validateAccount(wireTransfer.getDebitAccount());
		accountController.validateAccount(wireTransfer.getBeneficiaryAccount());

		//balance validation
		accountController.debitAccountBalanceCheck(wireTransfer.getDebitAccount(), wireTransfer.getAmount());
	}
}
