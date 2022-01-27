package com.vjvdg.graphqldemo.service.impl;

import com.vjvdg.graphqldemo.model.enums.ResponseStatus;
import com.vjvdg.graphqldemo.model.request.BaseRequest;
import com.vjvdg.graphqldemo.model.response.BaseResponse;
import com.vjvdg.graphqldemo.model.response.CountryResponse;
import com.vjvdg.graphqldemo.model.variables.CountryVariables;
import com.vjvdg.graphqldemo.service.BaseServiceHandler;
import com.vjvdg.graphqldemo.util.CountriesRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements BaseServiceHandler<CountryVariables, CountryResponse> {

    @Autowired
    private BaseServiceImpl<BaseRequest, CountryResponse> baseService;

    @Autowired
    private CountriesRequestBuilder countriesRequestBuilder;

    @Override
    public BaseResponse<CountryResponse> handle(CountryVariables countryVariables) {

        BaseRequest baseRequest = countriesRequestBuilder.buildRequest(countryVariables, "query_country.txt");

        HttpEntity<BaseRequest> entity = new HttpEntity<>(baseRequest);

        CountryResponse response = baseService.handlePostService(baseRequest, entity, CountryResponse.class);

        return BaseResponse.<CountryResponse>builder()
                .status(ResponseStatus.SUCCESS)
                .data(response)
                .build();

    }

    @Override
    public BaseResponse<CountryResponse> handle(String query, String id) {

        CountryVariables countryVariables = CountryVariables.builder().id(id).build();

        BaseRequest baseRequest = countriesRequestBuilder.buildRequestV2(countryVariables, query);

        HttpEntity<BaseRequest> entity = new HttpEntity<>(baseRequest);

        CountryResponse response = baseService.handlePostService(baseRequest, entity, CountryResponse.class);

        return BaseResponse.<CountryResponse>builder()
                .status(ResponseStatus.SUCCESS)
                .data(response)
                .build();

    }
}
