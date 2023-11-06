package com.openapi.papago.translation.dto;

import lombok.Getter;

public class Request {

    @Getter
    public static class Translation {

        private String source;

        private String target;

        private String text;
    }
}
