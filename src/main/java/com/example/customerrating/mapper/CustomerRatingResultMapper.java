package com.example.customerrating.mapper;

import com.example.customerrating.model.dto.CustomerRatingResultDto;
import com.example.customerrating.model.entity.CustomerRatingResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Маппер для результата оценки пользователя
 */
@Service
@RequiredArgsConstructor
public class CustomerRatingResultMapper {
	
	private final ObjectMapper objectMapper;
	
	public CustomerRatingResult dtoToEntity(CustomerRatingResultDto dto) {
		CustomerRatingResult entity = new CustomerRatingResult();
		entity.setFinalRating(dto.isFinalRating());
		try {
			entity.setDetailRating(objectMapper.writeValueAsString(dto.getDetailRating()));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		
		return entity;
	}
	
}
