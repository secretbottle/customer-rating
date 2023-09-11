package com.example.customerrating.service;

import com.example.customerrating.model.dto.CustomerInfoDto;
import com.example.customerrating.model.dto.CustomerRatingResultDto;

public interface CustomerRatingService {
	
	CustomerRatingResultDto rate(CustomerInfoDto customerInfoDto);
	
}
