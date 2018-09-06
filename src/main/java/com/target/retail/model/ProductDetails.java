package com.target.retail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.retail.documents.ProductPriceDetails;

public class ProductDetails {
    @JsonProperty(value = "id")
    public int id;
    @JsonProperty(value = "name")
    public String name;
    @JsonProperty(value = "current_price")
    public CurrentPrice currentPrice;

    public ProductDetails(int id, String name, CurrentPrice currentPrice) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }
}