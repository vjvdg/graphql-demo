package com.vjvdg.graphqldemo.model.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {

    private String code;
    private String name;
    @JsonProperty(value = "native")
    private String countryNative;
    private String phone;
    private Continent continent;
    private String capital;
    private String currency;
    private List<Language> languages;
    private String emoji;
    private String emojiU;
    private List<State> states;

}
