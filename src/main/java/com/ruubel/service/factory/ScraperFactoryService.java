package com.ruubel.service.factory;

import com.ruubel.service.strategy.BankScraperStrategy;
import com.ruubel.service.strategy.HttpFetchService;
import com.ruubel.service.strategy.SebScraper;
import com.ruubel.service.strategy.SwedbankScraper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ScraperFactoryService {

	private List<BankScraperStrategy> strategies;
	private HttpFetchService httpFetchService;

	public ScraperFactoryService() {
		httpFetchService = new HttpFetchService();
		strategies = createStrategies();
	}

	/**
	 * Internally creates objects, does not expose instantiation logic to the client.
	 */
	private List<BankScraperStrategy> createStrategies() {
		return new ArrayList<BankScraperStrategy>() {{
			add(new SebScraper(httpFetchService));
			add(new SwedbankScraper(httpFetchService));
		}};
	}

	/**
	 * Refers to the newly created object through a common interface
	 */
	public List<BankScraperStrategy> getStrategies() {
		return strategies;
	}

}
