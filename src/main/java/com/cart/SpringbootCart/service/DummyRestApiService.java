package com.cart.SpringbootCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DummyRestApiService {

   @Autowired
   private RestTemplate restTemplate;

   private static final String Api_url = "https://dummy.restapiexample.com/api/v1/employees";

    
    public String getEmployess() {
        return restTemplate.getForObject(Api_url, String.class);
    }
    
}
