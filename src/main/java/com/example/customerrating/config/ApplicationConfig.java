package com.example.customerrating.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
	
	private final static String DMN_FILE = "dmn/customer-rating.dmn";
	
	@Bean("dmnEngine")
	public DmnEngine dmnEngine() {
		return DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();
	}
	
	@Bean(name = "customerRatingDecisions")
	public List<DmnDecision> customerRatingDecisions(DmnEngine dmnEngine, ResourceLoader resourceLoader) throws IOException {
		Resource resource = resourceLoader.getResource("classpath:" + DMN_FILE);
		InputStream inputStream = resource.getInputStream();
		return dmnEngine.parseDecisions(inputStream);
	}
	
	@Bean("transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") final EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
}
