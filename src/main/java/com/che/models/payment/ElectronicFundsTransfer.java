package com.che.models.payment;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="ElectronicFundsTransfer")
@XmlType(name="ElectronicFundsTransfer")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElectronicFundsTransfer extends PaymentBaseEntity{

	@XmlElement(name="beneficiaryIbanNumber")
	private String beneficiaryIbanNumber;

	@XmlElement(name="beneficiaryBankCode")
	private String beneficiaryBankCode;

	public String getBeneficiaryIbanNumber() {
		return beneficiaryIbanNumber;
	}

	public void setBeneficiaryIbanNumber(String beneficiaryIbanNumber) {
		this.beneficiaryIbanNumber = beneficiaryIbanNumber;
	}

	public String getBeneficiaryBankCode() {
		return beneficiaryBankCode;
	}

	public void setBeneficiaryBankCode(String beneficiaryBankCode) {
		this.beneficiaryBankCode = beneficiaryBankCode;
	}

	@Override public String toString() {
		return "ElectronicFundsTransfer{" +
				"beneficiaryIbanNumber='" + beneficiaryIbanNumber + '\'' +
				", beneficiaryBankCode='" + beneficiaryBankCode + '\'' +
				'}';
	}
}
