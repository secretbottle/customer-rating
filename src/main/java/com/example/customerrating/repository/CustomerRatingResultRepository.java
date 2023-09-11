package com.example.customerrating.repository;

import com.example.customerrating.model.entity.CustomerRatingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий результата оценки пользователя.
 */
@Repository
public interface CustomerRatingResultRepository extends JpaRepository<CustomerRatingResult, Long> {

}
