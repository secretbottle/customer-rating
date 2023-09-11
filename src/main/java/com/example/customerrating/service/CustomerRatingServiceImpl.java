package com.example.customerrating.service;

import com.example.customerrating.mapper.CustomerRatingResultMapper;
import com.example.customerrating.model.dto.CustomerInfoDto;
import com.example.customerrating.model.dto.CustomerRatingResultDto;
import com.example.customerrating.repository.CustomerRatingResultRepository;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Service;

/**
 * Сервис оценки клиента.
 */
@Service
@RequiredArgsConstructor
public class CustomerRatingServiceImpl implements CustomerRatingService {
	
	private final DmnEngine dmnEngine;
	
	private final List<DmnDecision> dmnDecision;
	
	private final CustomerRatingResultRepository repository;
	
	private final CustomerRatingResultMapper mapper;
	
	@Override
	public CustomerRatingResultDto rate(CustomerInfoDto customerInfoDto) {
		VariableMap variables = Variables
				.putValue("type", customerInfoDto.getInn())
				.putValue("region", customerInfoDto.getRegion())
				.putValue("capital", customerInfoDto.getCapital())
				.putValue("resident", customerInfoDto.getInn());
		
		CustomerRatingResultDto customerRatingResultDto = new CustomerRatingResultDto();
		dmnDecision.forEach(r -> {
			Map<String, Object> map = dmnEngine.evaluateDecision(r, variables).getFirstResult().getEntryMap();
			String finalResultKey = "finalResult";
			if (map.containsKey(finalResultKey)) {
				customerRatingResultDto.setFinalRating((Boolean) map.get(finalResultKey));
			} else {
				customerRatingResultDto.getDetailRating().putAll(map);
			}
		});
		
		saveCustomerRatingResult(customerRatingResultDto);
		
		return customerRatingResultDto;
	}
	
	private void saveCustomerRatingResult(CustomerRatingResultDto customerRatingResultDto) {
		repository.save(mapper.dtoToEntity(customerRatingResultDto));
	}
}
