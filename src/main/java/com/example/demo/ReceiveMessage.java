package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMessage {

	@JmsListener(destination = "sampleQueue")
	public void receiveMessage(String msg) {
		System.out.println("Received : "+msg);
	}
}
