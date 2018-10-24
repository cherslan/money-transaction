package com.che.rest;

import com.che.transfer.Payment;
import com.che.transfer.PaymentImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class MoneyTransfer {

	@POST
	@Path("/doTransfer")
	@Consumes(MediaType.APPLICATION_XML)
	public void doTransfer(Object paymentModel){
		Payment payment = new PaymentImpl(paymentModel);
		payment.validateBeforeTransaction();
		payment.transferMoney();
	}

}
