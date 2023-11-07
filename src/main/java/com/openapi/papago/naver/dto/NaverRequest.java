package com.openapi.papago.naver.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class NaverRequest {

    @Getter
    public static class Translation {

        private String source;

        private String target;

        private String text;
    }

    @Getter
    @ToString
    public static class DataLab {

        private String startDate;

        private String endDate;

        private String timeUnit;

        private List<Keyword> keywordGroups;

        private String device;

        private String gender;

        private List<String> ages;

        @Getter
        @ToString
        public static class Keyword {

            private String groupName;

            private List<String> keywords;
        }
    }
}
