package com.alba.service.observer;

import com.alba.model.BankInformation;

import java.util.List;


public interface BankInformationReceived {
	void receivedBankInformation(List<BankInformation> data);
}
