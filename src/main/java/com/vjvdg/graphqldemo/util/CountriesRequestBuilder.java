package com.vjvdg.graphqldemo.util;

import com.vjvdg.graphqldemo.config.CountriesConfig;
import com.vjvdg.graphqldemo.exception.GenericException;
import com.vjvdg.graphqldemo.model.request.BaseRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class CountriesRequestBuilder {

    @Autowired
    private CountriesConfig config;

    public InputStream getResource(String filename) {
        return CountriesRequestBuilder.class.getClassLoader().getResourceAsStream(filename);
    }

    public String textFileToString(String filename) throws IOException {
        return IOUtils.toString(getResource(filename), StandardCharsets.UTF_8);
    }

    public BaseRequest buildRequest(Object queryVariables, String filename) {
        try {
            return BaseRequest.builder()
                    .url(config.getUrl())
                    .query(IOUtils.toString(getResource(filename), StandardCharsets.UTF_8))
                    .variables(queryVariables)
                    .build();
        } catch (Exception e) {
            throw new GenericException("E-001", "Oops! Something went wrong.");
        }
    }

    public BaseRequest buildRequestV2(Object queryVariables, String query) {
        try {
            return BaseRequest.builder()
                    .url(config.getUrl())
                    .query(query)
                    .variables(queryVariables)
                    .build();
        } catch (Exception e) {
            throw new GenericException("E-001", "Oops! Something went wrong.");
        }
    }

}
