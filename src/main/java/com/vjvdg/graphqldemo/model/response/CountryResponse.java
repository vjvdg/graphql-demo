package com.vjvdg.graphqldemo.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vjvdg.graphqldemo.model.base.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryResponse {

    private CountryData data;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class CountryData {

        private Country country;

    }
}
