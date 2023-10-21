package com.alba.service.observer;

import com.alba.model.BankInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaverService implements BankInformationReceived {

	private BankInformationPublisherService bankInformationPublisherService;

	@Autowired
	public SaverService(BankInformationPublisherService bankInformationPublisherService) {
		this.bankInformationPublisherService = bankInformationPublisherService;
		this.bankInformationPublisherService.subscribe(this);
	}

	@Override
	public void receivedBankInformation(List<BankInformation> data) {
		System.out.println("Saving: " + data);
	}
}
