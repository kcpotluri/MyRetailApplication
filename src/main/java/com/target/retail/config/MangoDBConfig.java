package com.target.retail.config;

import com.target.retail.documents.ProductPriceDetails;
import com.target.retail.repositories.ProductPriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = ProductPriceRepository.class)
@Configuration
public class MangoDBConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductPriceRepository productPrice) {
        return strings -> productPrice.save(new ProductPriceDetails(13860428, 13.49f, "USD"));
    }
}
