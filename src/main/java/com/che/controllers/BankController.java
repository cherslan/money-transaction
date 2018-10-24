package com.che.controllers;

import com.che.exceptions.NoSuchBankBranchException;
import com.che.exceptions.NoSuchBankException;
import com.che.exceptions.NoSuchSwiftCodeException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class BankController {

	//Dummy bank list
	private List<String> banks = Arrays.asList(
			"Bnk-001",
			"Bnk-002",
			"Bnk-003",
			"Bnk-004",
			"Bnk-005",
			"Bnk-006"
	);

	//dummy bank branch list
	private List<String> bankBranches = Arrays.asList(
			"Bnk-001-0001",
			"Bnk-001-0002",
			"Bnk-001-0003",
			"Bnk-002-0001",
			"Bnk-002-0002",
			"Bnk-002-0003",
			"Bnk-003-0001",
			"Bnk-003-0002",
			"Bnk-003-0003",
			"Bnk-004-0001",
			"Bnk-004-0002",
			"Bnk-004-0003",
			"Bnk-005-0001",
			"Bnk-005-0002",
			"Bnk-005-0003",
			"Bnk-006-0001",
			"Bnk-006-0002",
			"Bnk-006-0003"
	);

	private List<String> swiftCodes = Arrays.asList(
			"SWFT-ACX-001",
			"SWFT-ACX-002",
			"SWFT-ACX-003",
			"SWFT-ACX-004",
			"SWFT-ACX-005",
			"SWFT-ACX-006",
			"SWFT-ACX-007",
			"SWFT-ACX-008",
			"SWFT-ACX-009",
			"SWFT-ACX-0010",
			"SWFT-ACX-0011"
	);

	public List<String> getBanks() {
		return banks;
	}

	public void setBanks(List<String> banks) {
		this.banks = banks;
	}

	public List<String> getBankBranches() {
		return bankBranches;
	}

	public void setBankBranches(List<String> bankBranches) {
		this.bankBranches = bankBranches;
	}

	public List<String> getSwiftCodes() {
		return swiftCodes;
	}

	public void setSwiftCodes(List<String> swiftCodes) {
		this.swiftCodes = swiftCodes;
	}

	public void checkBank(String bankCode){
		boolean exist = banks.stream().anyMatch(bank -> bank.equals(bankCode));
		if(!exist){
			throw new NoSuchBankException();
		}
	}

	public void checkBankBranch(String bankBranchCode){
		boolean exist = bankBranches.stream().anyMatch(branch -> branch.equals(bankBranchCode));
		if(!exist){
			throw new NoSuchBankBranchException();
		}
	}

	public void checkSwiftCode(String bankSwiftCode){
		boolean exist = swiftCodes.stream().anyMatch(swift ->  swift.equals(bankSwiftCode));
		if(!exist){
			throw new NoSuchSwiftCodeException();
		}
	}
}
