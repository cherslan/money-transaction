package com.che.test;

import com.che.controllers.CustomerController;
import com.che.models.account.Account;
import com.che.models.payment.ElectronicFundsTransfer;
import com.che.models.payment.PaypalTransfer;
import com.che.models.payment.SwiftTransfer;
import com.che.models.payment.WireTransfer;
import com.che.rest.MoneyTransfer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AppTest {

	@BeforeClass
	public static void setup() throws JAXBException {
		CustomerController.loadStaticData();
	}

	@Test
	public void makeWireTransfer()
	{
		try {
			WireTransfer wireTransfer = new WireTransfer();
			Account drAcct = CustomerController.getCustomers().get(0).getAccounts().get(1);
			Account crAcct = CustomerController.getCustomers().get(1).getAccounts().get(0);
			wireTransfer.setBeneficiaryAccount(crAcct);
			wireTransfer.setDebitAccount(drAcct);
			wireTransfer.setAmount(10);

			MoneyTransfer moneyTransfer = new MoneyTransfer();
			moneyTransfer.doTransfer(wireTransfer);

			assertTrue(true);
		} catch (Throwable t) {
			fail();
		}

	}

	@Test
	public void makeEftTransfer(){
		try {
			ElectronicFundsTransfer eft = new ElectronicFundsTransfer();
			Account drAcct = CustomerController.getCustomers().get(2).getAccounts().get(1);

			eft.setBeneficiaryBankCode("Bnk-001");
			eft.setBeneficiaryIbanNumber("someIbanNumber");
			eft.setAmount(5);
			eft.setDebitAccount(drAcct);

			MoneyTransfer moneyTransfer = new MoneyTransfer();
			moneyTransfer.doTransfer(eft);

			assertTrue(true);
		} catch (Throwable t) {
			fail();
		}
	}

	@Test
	public void makeSwiftTransfer(){
		try {
			SwiftTransfer swift = new SwiftTransfer();
			Account drAcct = CustomerController.getCustomers().get(2).getAccounts().get(1);

			swift.setBeneficiaryAccount("acct-beneficiary-1");
			swift.setAccountType(SwiftTransfer.AccountType.IBAN);
			swift.setBeneficiaryBankCode("Bnk-001");
			swift.setBeneficiaryBranchCode("Bnk-001-0001");
			swift.setBeneficiaryBankSwiftCode("SWFT-ACX-001");
			swift.setAmount(25);
			swift.setDebitAccount(drAcct);

			MoneyTransfer moneyTransfer = new MoneyTransfer();
			moneyTransfer.doTransfer(swift);

			assertTrue(true);
		} catch (Throwable t) {
			fail();
		}
	}

	@Test
	public void makePaypalTransfer(){
		try {
			PaypalTransfer paypal = new PaypalTransfer();
			Account drAcct = CustomerController.getCustomers().get(2).getAccounts().get(1);

			paypal.setBeneficiaryAccountMailAddress("someEaddress@some.com");
			paypal.setAmount(45);
			paypal.setDebitAccount(drAcct);

			MoneyTransfer moneyTransfer = new MoneyTransfer();
			moneyTransfer.doTransfer(paypal);

			assertTrue(true);
		} catch (Throwable t) {
			fail();
		}
	}
}
