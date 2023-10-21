package com.alba.service;

import com.alba.model.BankInformation;
import com.alba.service.factory.ScraperFactoryService;
import com.alba.service.observer.BankInformationPublisherService;
import com.alba.service.strategy.BankScraperStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

	private BankInformationPublisherService bankInformationPublisherService;
	private ScraperFactoryService scraperFactoryService;

	@Autowired
	public BankService(BankInformationPublisherService bankInformationPublisherService, ScraperFactoryService scraperFactoryService) {
		this.bankInformationPublisherService = bankInformationPublisherService;
		this.scraperFactoryService = scraperFactoryService;
	}

	public List<BankInformation> getContacts() {
		List<BankInformation> bankInformations = new ArrayList<>();
		for (BankScraperStrategy strategy : scraperFactoryService.getStrategies()) {
			BankInformation bank = strategy.scrape();
			bankInformations.add(bank);
		}
		bankInformationPublisherService.publish(bankInformations);
		return bankInformations;
	}

}
