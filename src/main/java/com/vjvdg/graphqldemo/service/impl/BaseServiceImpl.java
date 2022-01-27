package com.vjvdg.graphqldemo.service.impl;

import com.vjvdg.graphqldemo.exception.GenericException;
import com.vjvdg.graphqldemo.model.request.BaseRequest;
import com.vjvdg.graphqldemo.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BaseServiceImpl<U, V> implements BaseService<U, V> {

    @Autowired
    private RestTemplate restTemplate;

    public V handlePostService(BaseRequest baseRequest, HttpEntity<U> httpEntity, Class<V> vClass) {

        try {
            return restTemplate.exchange(baseRequest.getUrl(), HttpMethod.POST, httpEntity, vClass).getBody();
        } catch (HttpClientErrorException httpClientErrorException) {
            log.info("RestTemplate exchange failed");
            log.info(httpClientErrorException.getResponseBodyAsString());
            throw new GenericException("E-001", "Oops! Something went wrong.");
        }

    }

}
