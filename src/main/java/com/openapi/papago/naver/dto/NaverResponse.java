package com.openapi.papago.naver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

public class NaverResponse {

    @Getter
    @ToString
    public static class Papago {

        private Message message;

        @Getter
        @ToString
        public static class Message {

            @JsonProperty("@type")
            private String type;

            @JsonProperty("@service")
            private String service;

            @JsonProperty("@version")
            private String version;

            private Result result;
        }

        @Getter
        @ToString
        public static class Result {

            private String srcLangType;

            private String tarLangType;

            private String translatedText;

            private String engineType;
        }
    }
}
