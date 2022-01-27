package com.vjvdg.graphqldemo.service;

import com.vjvdg.graphqldemo.model.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface BaseServiceHandler<U, V> {

    BaseResponse<V> handle(U u);

    BaseResponse<V> handle(String query, String id);

}
