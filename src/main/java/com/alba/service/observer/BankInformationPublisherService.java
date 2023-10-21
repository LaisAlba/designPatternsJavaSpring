package com.alba.service.observer;

import com.alba.model.BankInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BankInformationPublisherService {

	private List<BankInformationReceived> subscribers;

	public BankInformationPublisherService() {
		subscribers = new ArrayList<>();
	}

	/**
	 * Services can "sign up" here to receive updates
	 * @param subscriber
	 */
	public void subscribe(BankInformationReceived subscriber) {
		subscribers.add(subscriber);
	}

	/**
	 * Service can "opt-out" from receiving these updates
	 * @param subscriber
	 */
	public void unsubscribe(BankInformationReceived subscriber) {
		subscribers.remove(subscriber);
	}

	/**
	 * This is called when desired event happens, all subscribers will be informed
	 */
	public void publish(List<BankInformation> data) {
		for (BankInformationReceived subscriber : subscribers) {
			subscriber.receivedBankInformation(data);
		}
	}

}
