package com.yoon.HowtoUseRabbitMq.receiver.module;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.yoon.HowtoUseRabbitMq.dto.Dept;

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
	
//	@RabbitListener(bindings = @QueueBinding(
//			exchange = @Exchange(name="dept", type = ExchangeTypes.TOPIC),
//			value = @Queue(name="dept-second"),
//			key = "dept-first"
//	))
//	public void receiver2(Dept dept) {
//		System.out.println("2 ===> "+dept.toString());
//	}
	

	/**
	 * 받은걸 다시 보내는 
	 * */
	
	@RabbitListener(bindings = @QueueBinding(
			exchange = @Exchange(name="dept", type = ExchangeTypes.TOPIC),
			value = @Queue(name="dept-second"),
			key = "dept-first"
	))
	//@SendTo(exchange/key)
	@SendTo("dept/dept-third")
	public Dept receiverAndSend(Dept dept) {
		System.out.println("2 >> from sender 받았음: "+dept.toString());
		
		Dept newDept = new Dept(20, "new", "new", "");
		System.out.println("3 << receiver to sender 보냈음: "+newDept.toString());
		return newDept;
	}
	
	
	@RabbitListener(bindings = @QueueBinding(
			exchange = @Exchange(name="dept", type = ExchangeTypes.TOPIC),
			value = @Queue(name="dept-fourth"),
			key = "dept-third"
	))
	public void receiver3(Dept dept) {
		System.out.println("4 >> receiver to receiver 받았음: "+dept.toString());
	}
}
