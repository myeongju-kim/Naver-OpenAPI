package com.openapi.papago.translation.service.impl;

import com.openapi.papago.naver.dto.NaverResponse;
import com.openapi.papago.naver.feign.NaverFeign;
import com.openapi.papago.translation.dto.Request;
import com.openapi.papago.translation.dto.Response;
import com.openapi.papago.translation.service.TranslationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {

    private final NaverFeign naverFeign;

    @Override
    public Response.Translation translateContents(Request.Translation request) {
        NaverResponse.Papago papagoResponse = naverFeign.translatedText(request.getSource(), request.getTarget(), request.getText());

        log.info("Papago Response : {}", papagoResponse);
        return Response.Translation.builder()
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
}
