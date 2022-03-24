package com.capgemini.pokecity.utils;

import com.capgemini.pokecity.exception.URLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class RestUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestUtils.class);

    public static Object getRestResponse(String url, Class classe) throws URLException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            LOGGER.info("Accessing External API");
            return restTemplate.exchange(url, HttpMethod.GET, entity, classe).getBody();
        }catch(Exception e){
            LOGGER.error(e.getMessage());
            throw new URLException(e.getMessage());
        }
    }

}
