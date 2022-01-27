package com.vjvdg.graphqldemo.controller;

import com.vjvdg.graphqldemo.constant.ApplicationConstants;
import com.vjvdg.graphqldemo.model.response.BaseResponse;
import com.vjvdg.graphqldemo.model.response.CountryResponse;
import com.vjvdg.graphqldemo.model.variables.CountryVariables;
import com.vjvdg.graphqldemo.service.impl.CountryServiceImpl;
import com.vjvdg.graphqldemo.util.CountriesRequestBuilder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class Controller {

    @Autowired
    private CountryServiceImpl countryService;

    @Autowired
    private CountriesRequestBuilder countriesRequestBuilder;

    @PostMapping(value = "/retrieve/country")
    public BaseResponse<CountryResponse> getCountry(@RequestBody CountryVariables countryVariables) {
        return countryService.handle(countryVariables);
    }

    @PostMapping(value = "/retrieve/country/alt")
    public BaseResponse<CountryResponse> getCountryAlt(@RequestBody @Schema(example = ApplicationConstants.COUNTRY_QUERY) String query,
                                                       @RequestParam @Schema(example = "SG") String id) {
        return countryService.handle(query, id);
    }

}
