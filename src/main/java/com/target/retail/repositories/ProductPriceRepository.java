package com.target.retail.repositories;

import com.target.retail.documents.ProductPriceDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductPriceRepository extends MongoRepository<ProductPriceDetails, Integer> {

}
