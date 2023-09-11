package com.example.customerrating.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO информации клиента.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfoDto {

	private String inn;
	
	private Double capital;
	
	private Integer region;
	
}
