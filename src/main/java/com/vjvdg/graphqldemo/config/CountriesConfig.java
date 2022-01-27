package com.vjvdg.graphqldemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.trevorblades.countries")
public class CountriesConfig {

    private String url;

}
