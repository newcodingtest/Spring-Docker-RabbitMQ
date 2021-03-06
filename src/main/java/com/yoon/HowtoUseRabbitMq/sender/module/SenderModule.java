package com.yoon.HowtoUseRabbitMq.sender.module;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration; 
import org.springframework.scheduling.annotation.Scheduled;

import com.yoon.HowtoUseRabbitMq.dto.Dept;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SenderModule {

	private final RabbitTemplate rabbitTemplate;
	
	/**
	 * fixedDelay는 해당 작업이 끝난 시점부터 시간을 세고, fixedRate는 해당 작업의 시작 시점부터 시간을 셈
	 * */
	//@Scheduled(fixedRate = 1000)
	public void sender1() {
		
		LocalDateTime nowTime = LocalDateTime.now();
		String time = nowTime.toString();
		
		System.out.println("<=== "+time);
		
		//exchange, routingKey, value
		rabbitTemplate.convertAndSend("time","time-first",time);
	}
	
	@Scheduled(fixedRate = 1000)
	public void sender2() {
		
		LocalDateTime nowTime = LocalDateTime.now();
		String time = nowTime.toString();
		Dept dept = new Dept(10,"test","test",time);
		System.out.println("1 <<< sender to receiver 보냈음: "+dept.toString());
		
		//exchange, routingKey, value
		rabbitTemplate.convertAndSend("dept","dept-first",dept);
	}
}
