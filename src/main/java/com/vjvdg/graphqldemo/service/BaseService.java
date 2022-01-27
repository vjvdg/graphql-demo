package com.vjvdg.graphqldemo.service;

import com.vjvdg.graphqldemo.model.request.BaseRequest;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public interface BaseService<U, V> {

    V handlePostService(BaseRequest baseRequest, HttpEntity<U> httpEntity, Class<V> vClass);

}
