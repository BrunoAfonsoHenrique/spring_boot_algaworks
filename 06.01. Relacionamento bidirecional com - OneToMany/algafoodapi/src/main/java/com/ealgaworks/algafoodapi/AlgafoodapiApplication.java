package com.ealgaworks.algafoodapi;

import com.ealgaworks.algafoodapi.api.domain.infrastructure.repository.CustomJpaRepositoryImpl;
import com.ealgaworks.algafoodapi.api.domain.repository.CustomJpaRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class AlgafoodapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgafoodapiApplication.class, args);
	}


}
