package com.che.transfer;

import com.che.exceptions.UnsuccessfulPaymentException;

public interface Payment {

	void transferMoney() throws UnsuccessfulPaymentException;

	void validateBeforeTransaction();

}
