package com.openapi.papago.naver.service.impl;

import com.openapi.papago.naver.dto.NaverResponse;
import com.openapi.papago.naver.feign.NaverFeign;
import com.openapi.papago.naver.dto.NaverRequest;
import com.openapi.papago.naver.service.NaverService;
import com.openapi.papago.naver.dto.ServerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NaverServiceImpl implements NaverService {

    private final NaverFeign naverFeign;

    @Override
    public ServerResponse.Translation translateContents(NaverRequest.Translation request) {
        NaverResponse.Papago papagoResponse = naverFeign.translatedText(request.getSource(), request.getTarget(), request.getText());

        log.info("Papago Response : {}", papagoResponse);
        return ServerResponse.Translation.builder()
                                         .originalLanguage(request.getSource())
                                         .originalText(request.getText())
                                         .translatedLanguage(papagoResponse.getMessage()
                                                                           .getResult()
                                                                           .getTarLangType())
                                         .translatedText(papagoResponse.getMessage()
                                                                       .getResult()
                                                                       .getTranslatedText())
                                         .build();
    }

    @Override
    public ServerResponse.DataLab getSearchTrend(NaverRequest.DataLab request) {
        NaverResponse.DataLab dataLabResponse = naverFeign.getSearchTrend(request);
        log.info("dataLabResponse : {}", dataLabResponse);

        return ServerResponse.DataLab.builder()
                                     .startDate(request.getStartDate())
                                     .endDate(request.getEndDate())
                                     .build();
    }
}
