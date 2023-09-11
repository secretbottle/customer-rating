package com.example.customerrating.model.dto;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO результата оценки клиента.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRatingResultDto {
	
	private boolean finalRating;
	
	private Map<String, Object> detailRating = new HashMap<>();
	
}
