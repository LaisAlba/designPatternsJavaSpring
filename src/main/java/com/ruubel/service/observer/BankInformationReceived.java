package com.ruubel.service.observer;

import com.ruubel.model.BankInformation;

import java.util.List;


public interface BankInformationReceived {
	void receivedBankInformation(List<BankInformation> data);
}
