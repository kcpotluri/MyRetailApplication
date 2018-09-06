package com.target.retail.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.retail.config.AppConfig;
import com.target.retail.documents.ProductPriceDetails;
import com.target.retail.model.CurrentPrice;
import com.target.retail.model.ProductDetails;
import com.target.retail.outbound.model.Product;

import com.target.retail.outbound.httpRequest.OutboundHttpRequest;
import com.target.retail.repositories.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
@ComponentScan({"com.target.retail"})
public class InboundHttpRequest {
    @Autowired
    private AppConfig config;
    @Autowired
    private ProductPriceRepository productPriceRepository;

    @RequestMapping(value = "/products/{id}", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getProductInfo(@PathVariable("id") int id) {
        Product product = OutboundHttpRequest.FetchProductInfo(config, id);
        String title = "";
        if (product != null) {
            title = product.getItem().getProductDescription().getTitle();
        }
        String serialized = "";
        CurrentPrice currentPrice = new CurrentPrice(0, "USD");
        Optional<ProductPriceDetails> productPriceById = productPriceRepository.findById(id);
        if (productPriceById.isPresent()) {
            currentPrice = new CurrentPrice(productPriceById.get().getValue(), productPriceById.get().getCurrencyCode());
        }
        try {
            serialized = new ObjectMapper().writeValueAsString(new ProductDetails(id, title, currentPrice));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return serialized;
    }

    @RequestMapping(value = "/products/{id}", method = {RequestMethod.PUT})
    public void updatePrices(@RequestBody ProductDetails productDetails) {
        //System.out.println("Product Details are  :" + productDetails.getId() + productDetails);
        ProductPriceDetails productPriceDetails = new ProductPriceDetails(productDetails.getId(), productDetails.getCurrentPrice().getValue(), productDetails.getCurrentPrice().getCurrencyCode());
        System.out.println(productPriceRepository.save(productPriceDetails));
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<ProductPriceDetails> getAllPrices() {
        return productPriceRepository.findAll();
    }
}
