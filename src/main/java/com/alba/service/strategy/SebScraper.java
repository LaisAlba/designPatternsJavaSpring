package com.alba.service.strategy;

import com.alba.model.Bank;
import com.alba.model.BankInformation;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class SebScraper implements BankScraperStrategy {

	private String bankUrl = "http://www.seb.ee/eng/contact/contact";
	private HttpFetchService httpFetchService;

	public SebScraper(HttpFetchService httpFetchService) {
		this.httpFetchService = httpFetchService;
	}

	@Override
	public BankInformation scrape() {
		String number = "FAILED";
		try {
			Document doc = httpFetchService.get(bankUrl);

			Elements content = doc.select(".field-type-text-with-summary");
			Elements tables = content.get(0).select("table");
			Elements tds = tables.get(0).select("td");
			number = tds.get(3).text();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new BankInformation(Bank.SEB, number);
	}
}
