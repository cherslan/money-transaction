package com.che.transfer;

import com.che.controllers.AccountController;
import com.che.controllers.BankController;
import com.che.exceptions.*;
import com.che.models.payment.ElectronicFundsTransfer;

public class EftPaymentImpl implements Payment {

	private ElectronicFundsTransfer eftTransfer;
	private AccountController       accountController;
	private BankController          bankController;

	public EftPaymentImpl(ElectronicFundsTransfer eftTransfer) {
		this.eftTransfer = eftTransfer;
		this.accountController = new AccountController();
		this.bankController = new BankController();
	}

	@Override public void transferMoney() throws UnsuccessfulPaymentException {
		try {
			// eft api usage comes here
			accountController.withdrawMoney(eftTransfer.getDebitAccount(), eftTransfer.getAmount());
			System.out.println("##EFT transaction has been completed");
		} catch (Throwable t) {
			throw new UnsuccessfulPaymentException(t.getMessage(), t);
		}
	}

	@Override public void validateBeforeTransaction()
			throws NotAvailableAccountBalanceException,
			NoSuchCustomerException,
			NoSuchAccountException,
			NoSuchBankException,
			InvalidIbanNumberException
	{
		accountController.validateAccount(eftTransfer.getDebitAccount());
		accountController.validateIbanNumber(eftTransfer.getDebitAccount().getIbanNumber());
		accountController.validateIbanNumber(eftTransfer.getBeneficiaryIbanNumber());

		bankController.checkBank(eftTransfer.getBeneficiaryBankCode());
		accountController.debitAccountBalanceCheck(eftTransfer.getDebitAccount(), eftTransfer.getAmount());
	}
}
