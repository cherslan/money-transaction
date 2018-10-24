package com.che.models.payment;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="SwiftTransfer")
@XmlType(name="SwiftTransfer")
@XmlAccessorType(XmlAccessType.FIELD)
public class SwiftTransfer extends PaymentBaseEntity {

	@XmlEnum
	public enum AccountType{
		IBAN,
		ACCOUNT
	}

	@XmlElement(name="beneficiaryAccount")
	private String beneficiaryAccount;

	@XmlElement(name="beneficiaryBankSwiftCode")
	private String beneficiaryBankSwiftCode;

	@XmlElement(name="beneficiaryBankCode")
	private String beneficiaryBankCode;

	@XmlElement(name="beneficiaryBranchCode")
	private String beneficiaryBranchCode;

	@XmlElement(name="accountType")
	private AccountType accountType;

	public String getBeneficiaryAccount() {
		return beneficiaryAccount;
	}

	public void setBeneficiaryAccount(String beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}

	public String getBeneficiaryBankSwiftCode() {
		return beneficiaryBankSwiftCode;
	}

	public void setBeneficiaryBankSwiftCode(String beneficiaryBankSwiftCode) {
		this.beneficiaryBankSwiftCode = beneficiaryBankSwiftCode;
	}

	public String getBeneficiaryBankCode() {
		return beneficiaryBankCode;
	}

	public void setBeneficiaryBankCode(String beneficiaryBankCode) {
		this.beneficiaryBankCode = beneficiaryBankCode;
	}

	public String getBeneficiaryBranchCode() {
		return beneficiaryBranchCode;
	}

	public void setBeneficiaryBranchCode(String beneficiaryBranchCode) {
		this.beneficiaryBranchCode = beneficiaryBranchCode;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override public String toString() {
		return "SwiftTransfer{" +
				"beneficiaryAccount=" + beneficiaryAccount +
				", beneficiaryBankSwiftCode='" + beneficiaryBankSwiftCode + '\'' +
				", beneficiaryBankCode='" + beneficiaryBankCode + '\'' +
				", beneficiaryBranchCode='" + beneficiaryBranchCode + '\'' +
				", accountType=" + accountType +
				'}';
	}
}
