package com.example.customerrating.service;

import com.example.customerrating.model.dto.CustomerInfoDto;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class CustomerRatingServiceImplTest {
	
	@Autowired
	private CustomerRatingService customerRatingService;
	
	@Test
	void rate_IsTrue() {
		CustomerInfoDto customerInfoDto = new CustomerInfoDto();
		customerInfoDto.setInn("990911223344");
		customerInfoDto.setRegion(24);
		customerInfoDto.setCapital(4000000.0);
		
		Map<String, Boolean> detailRatings = new HashMap<>();
		detailRatings.put("type", true);
		detailRatings.put("region", true);
		detailRatings.put("capital", true);
		detailRatings.put("resident", true);
		
		Assertions.assertTrue(customerRatingService.rate(customerInfoDto).isFinalRating());
		Assertions.assertEquals(detailRatings, customerRatingService.rate(customerInfoDto).getDetailRating());
	}
	
	@Test
	void rate_IsFalse() {
		CustomerInfoDto customerInfoDto = new CustomerInfoDto();
		customerInfoDto.setInn("990911223344");
		customerInfoDto.setCapital(6000000.0);
		
		Map<String, Boolean> detailRatings = new HashMap<>();
		detailRatings.put("type", true);
		detailRatings.put("region", false);
		detailRatings.put("capital", false);
		detailRatings.put("resident", true);
		
		Assertions.assertFalse(customerRatingService.rate(customerInfoDto).isFinalRating());
		Assertions.assertEquals(detailRatings, customerRatingService.rate(customerInfoDto).getDetailRating());
	}
	
}