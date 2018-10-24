package com.che.transfer;

import com.che.controllers.AccountController;
import com.che.controllers.BankController;
import com.che.exceptions.*;
import com.che.models.payment.SwiftTransfer;

public class SwiftPaymentImpl implements Payment {
	private SwiftTransfer     swiftTransfer;
	private AccountController accountController;
	private BankController    bankController;

	public SwiftPaymentImpl(SwiftTransfer swiftTransfer) {
		this.swiftTransfer = swiftTransfer;
		this.accountController = new AccountController();
		this.bankController = new BankController();
	}

	@Override public void transferMoney() throws UnsuccessfulPaymentException {
		try {
			// swift api usage comes here
			accountController.withdrawMoney(swiftTransfer.getDebitAccount(), swiftTransfer.getAmount());
			System.out.println("##Swift transaction has been completed");
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
		//Account validation
		accountController.validateAccount(swiftTransfer.getDebitAccount());
		if (swiftTransfer.getAccountType() == SwiftTransfer.AccountType.IBAN) {
			accountController.validateIbanNumber(swiftTransfer.getDebitAccount().getIbanNumber());
			accountController.validateIbanNumber(swiftTransfer.getBeneficiaryAccount());

		}

		//swift and bank checks
		bankController.checkBank(swiftTransfer.getBeneficiaryBankCode());
		bankController.checkBankBranch(swiftTransfer.getBeneficiaryBranchCode());
		bankController.checkSwiftCode(swiftTransfer.getBeneficiaryBankSwiftCode());

		//balance check
		accountController.debitAccountBalanceCheck(swiftTransfer.getDebitAccount(), swiftTransfer.getAmount());
	}
}
