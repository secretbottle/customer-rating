package com.example.customerrating.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RATING_RESULT")
@Getter
@Setter
@NoArgsConstructor
public class CustomerRatingResult implements Serializable {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
	)
	@Column(
			name = "id",
			nullable = false
	)
	private Long id;
	
	@Column
	private boolean finalRating;
	
	@Column
	private String detailRating;
	
}
