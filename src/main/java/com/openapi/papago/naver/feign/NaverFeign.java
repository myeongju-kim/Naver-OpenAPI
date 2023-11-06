package com.openapi.papago.naver.feign;

import com.openapi.papago.naver.config.NaverConfiguration;
import com.openapi.papago.naver.dto.NaverResponse;
import com.openapi.papago.translation.dto.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "naver-open-api", url = "${naver.url}", configuration = NaverConfiguration.class)
public interface NaverFeign {

    @PostMapping("papago/n2mt")
    NaverResponse.Papago translatedText(@RequestParam(value = "source") String source,
                                        @RequestParam(value = "target") String target,
                                        @RequestParam(value = "text") String text);
}
