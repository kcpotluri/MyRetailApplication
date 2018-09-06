package com.target.retail.outbound.httpRequest;

import com.target.retail.config.AppConfig;
import com.target.retail.outbound.model.Product;
import com.target.retail.outbound.model.Response;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class OutboundHttpRequest {
    private static final String replaceString = "{id}";

    public static Product FetchProductInfo(AppConfig config, int productId) {
        String productInfoURL = config.getUrl().replace(replaceString, Integer.toString(productId));
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> entity = new HttpEntity<>(new HttpHeaders());
        try {
            ResponseEntity<Response> response = restTemplate.exchange(productInfoURL, HttpMethod.GET, entity, Response.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                Response resp = response.getBody();
                return resp.getProduct();
            }
        } catch (Exception e) {
            System.out.println("Failed to get response from the Server with error " + e.getMessage());
        }
        return null;
    }
}
