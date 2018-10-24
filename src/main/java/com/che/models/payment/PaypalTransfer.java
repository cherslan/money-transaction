package com.che.models.payment;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="PaypalTransfer")
@XmlType(name="PaypalTransfer")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaypalTransfer extends PaymentBaseEntity {

	@XmlElement(name="beneficiaryAccountMailAddress")
	private String beneficiaryAccountMailAddress;

	public String getBeneficiaryAccountMailAddress() {
		return beneficiaryAccountMailAddress;
	}

	public void setBeneficiaryAccountMailAddress(String beneficiaryAccountMailAddress) {
		this.beneficiaryAccountMailAddress = beneficiaryAccountMailAddress;
	}

	@Override public String toString() {
		return "PaypalTransfer{" +
				"beneficiaryAccountMailAddress='" + beneficiaryAccountMailAddress + '\'' +
				'}';
	}
}
