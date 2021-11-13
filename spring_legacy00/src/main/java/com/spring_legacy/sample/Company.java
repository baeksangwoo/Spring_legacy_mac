package com.spring_legacy.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Company {
	@Autowired
	@Setter
	private Employee employee;
}
