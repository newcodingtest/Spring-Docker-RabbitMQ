package com.yoon.HowtoUseRabbitMq.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

	Integer deptno;
	String dname;
	String loc;
	String time;
}
