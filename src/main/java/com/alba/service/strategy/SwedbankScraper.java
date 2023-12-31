package com.alba.service.strategy;

import com.alba.model.Bank;
import com.alba.model.BankInformation;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SwedbankScraper implements BankScraperStrategy {

	private String bankUrl = "https://www.swedbank.ee/private/home/more/channels?language=EST";
	private HttpFetchService httpFetchService;

	public SwedbankScraper(HttpFetchService httpFetchService) {
		this.httpFetchService = httpFetchService;
	}

	@Override
	public BankInformation scrape() {
		String number = "FAILED";
		try {
			Document doc = httpFetchService.get(bankUrl);

			Elements footers = doc.select("section.footer-section");
			Element tel = footers.get(0).select("div.tel").get(0);
			number = tel.text();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new BankInformation(Bank.SWEDBANK, number);
	}
}
