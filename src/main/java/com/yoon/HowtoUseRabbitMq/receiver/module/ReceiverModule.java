package com.yoon.HowtoUseRabbitMq.receiver.module;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverModule {

	@RabbitListener(bindings = @QueueBinding(
			exchange = @Exchange(name="time", type = ExchangeTypes.TOPIC),
			value = @Queue(name="time-second"),
			key = "time-first"
	))
	public void receiver(String msg) {
		System.out.println("===> "+msg);
	}
}
