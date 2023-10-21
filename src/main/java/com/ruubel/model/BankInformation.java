package com.ruubel.model;

public class BankInformation {

	private Bank bank;
	private String phoneNumber;

	public BankInformation(Bank bank, String phoneNumber) {
		this.bank = bank;
		this.phoneNumber = phoneNumber;
	}

	public Bank getBank() {
		return bank;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return "BankInformation{" +
				"bank=" + bank +
				", phoneNumber='" + phoneNumber + '\'' +
				'}';
	}
}
