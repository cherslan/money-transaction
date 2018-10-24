package com.che.transfer;

import com.che.exceptions.*;
import com.che.models.payment.ElectronicFundsTransfer;
import com.che.models.payment.PaypalTransfer;
import com.che.models.payment.SwiftTransfer;
import com.che.models.payment.WireTransfer;

public class PaymentImpl implements Payment {

	private Payment instance;

	private Object	transferModel;

	public PaymentImpl(Object transferModel) throws NullPointerException, NoSuchPaymentTypeException{
		if(transferModel == null){
			throw new NullPointerException("TransferModel cannot be null");
		}

		this.transferModel = transferModel;

		if(this.transferModel instanceof SwiftTransfer){
			this.instance = new SwiftPaymentImpl((SwiftTransfer) transferModel);
		} else if(this.transferModel instanceof ElectronicFundsTransfer){
			this.instance = new EftPaymentImpl((ElectronicFundsTransfer) transferModel);
		} else if(this.transferModel instanceof WireTransfer){
			this.instance = new WirePaymentImpl((WireTransfer) transferModel);
		} else if(this.transferModel instanceof PaypalTransfer){
			this.instance = new PaypalPaymentImpl((PaypalTransfer) transferModel);
		} else {
			throw new NoSuchPaymentTypeException();
		}
	}

	@Override public void transferMoney() throws UnsuccessfulPaymentException {
		instance.transferMoney();
	}

	@Override public void validateBeforeTransaction() throws NotAvailableAccountBalanceException,
			NoSuchCustomerException,
			NoSuchAccountException,
			NoSuchBankException,
			InvalidIbanNumberException,
			InvalidEmailException{
		instance.validateBeforeTransaction();
	}
}
