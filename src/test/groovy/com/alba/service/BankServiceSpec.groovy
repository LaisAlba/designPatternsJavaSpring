package com.alba.service

import com.alba.model.Bank
import com.alba.model.BankInformation
import com.alba.service.factory.ScraperFactoryService
import com.alba.service.observer.BankInformationPublisherService
import com.alba.service.strategy.BankScraperStrategy
import spock.lang.Specification

class BankServiceSpec extends Specification {

    BankService service
    BankInformationPublisherService bankInformationPublisherService
    ScraperFactoryService scraperFactoryService

    def setup() {
        bankInformationPublisherService = Mock(BankInformationPublisherService)
        scraperFactoryService = Mock(ScraperFactoryService)
        service = new BankService(bankInformationPublisherService, scraperFactoryService)
    }

    def "when empty list of strategies is defined, then scrapes none, publishes and returns empty list" () {
        when:
            List<BankInformation> contacts = service.getContacts()
        then:
            1 * service.scraperFactoryService.getStrategies() >> []
            1 * bankInformationPublisherService.publish([])
            contacts == []
    }

    def "when strategy is defined, then scrapes it, publishes and returns on element list" () {
        given:
            BankScraperStrategy scraper = Mock(BankScraperStrategy)
            BankInformation scrapeResult = new BankInformation(Bank.SEB, "12345")
        when:
            List<BankInformation> contacts = service.getContacts()
        then:
            1 * scraperFactoryService.getStrategies() >> [scraper]
            1 * scraper.scrape() >> scrapeResult
            1 * bankInformationPublisherService.publish([scrapeResult])
            contacts == [scrapeResult]
    }

}
