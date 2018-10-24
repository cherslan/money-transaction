package com.che.models.payment;

import com.che.models.account.Account;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="WireTransfer")
@XmlType(name="WireTransfer")
@XmlAccessorType(XmlAccessType.FIELD)
public class WireTransfer extends PaymentBaseEntity{

	@XmlElement(name="beneficiaryAccount")
	private Account beneficiaryAccount;

	public Account getBeneficiaryAccount() {
		return beneficiaryAccount;
	}

	public void setBeneficiaryAccount(Account beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}


	@Override public String toString() {
		return "Wire{" +
				"beneficiaryAccount=" + beneficiaryAccount +
				", debitAccount=" + getDebitAccount() +
				'}';
	}
}
