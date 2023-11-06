package com.openapi.papago.translation.dto;

import lombok.Builder;
import lombok.Getter;

public class Response {

    @Getter
    @Builder
    public static class Translation {

        private String originalLanguage;

        private String originalText;

        private String translatedLanguage;

        private String translatedText;
    }
}
