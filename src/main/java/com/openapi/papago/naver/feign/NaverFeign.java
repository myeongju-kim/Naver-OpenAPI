package com.openapi.papago.naver.feign;

import com.openapi.papago.naver.config.NaverConfiguration;
import com.openapi.papago.naver.dto.NaverRequest;
import com.openapi.papago.naver.dto.NaverResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "naver-open-api", url = "${naver.url}", configuration = NaverConfiguration.class)
public interface NaverFeign {

    @PostMapping(value = "/papago/n2mt", consumes = "application/x-www-form-urlencoded")
    NaverResponse.Papago translatedText(@RequestParam(value = "source") String source,
                                        @RequestParam(value = "target") String target,
                                        @RequestParam(value = "text") String text);

    @PostMapping("/datalab/search")
    NaverResponse.DataLab getSearchTrend(@RequestBody NaverRequest.DataLab request);
}
