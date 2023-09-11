package com.example.customerrating.controller;

import com.example.customerrating.model.dto.CustomerInfoDto;
import com.example.customerrating.model.dto.CustomerRatingResultDto;
import com.example.customerrating.service.CustomerRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер оценки клиента.
 */
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerRatingController {
	
	private final CustomerRatingService customerRatingService;
	
	@PostMapping("/rate")
	public CustomerRatingResultDto rate(@RequestBody CustomerInfoDto customerInfoDto) {
		return customerRatingService.rate(customerInfoDto);
	}
	
}
