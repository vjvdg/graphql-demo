package com.vjvdg.graphqldemo.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vjvdg.graphqldemo.model.enums.ResponseStatus;
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
public class BaseResponse<V> {

    private ResponseStatus status;
    private V data;
    private ResponseError error;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseError {

        private List<Error> errors;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Error {

            private String message;
            private List<Location> locations;
            private Extension extensions;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Location {

                private Integer line;
                private Integer column;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Extension {

                private String code;
            }

        }

    }

}
