package com.target.retail.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentPrice {
    @JsonProperty(value = "value")
    public float value;
    @JsonProperty(value = "currency_code")
    public String currencyCode;

    public CurrentPrice(float value, String currencyCode) {
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
