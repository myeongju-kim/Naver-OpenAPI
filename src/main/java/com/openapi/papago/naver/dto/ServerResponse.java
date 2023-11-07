package com.openapi.papago.naver.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class ServerResponse {

    @Getter
    @Builder
    public static class Translation {

        private String originalLanguage;

        private String originalText;

        private String translatedLanguage;

        private String translatedText;
    }

    @Getter
    @Builder
    public static class DataLab {

        private String startDate;

        private String endDate;

        private List<String> keywords;

        private List<Data> dataList;

        @Getter
        @ToString
        public static class Data {

            private String period;

            private String ratio;
        }
    }
}
