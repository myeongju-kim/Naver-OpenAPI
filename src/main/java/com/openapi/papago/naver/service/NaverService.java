package com.openapi.papago.naver.service;


import com.openapi.papago.naver.dto.NaverRequest;
import com.openapi.papago.naver.dto.ServerResponse;

public interface NaverService {

    ServerResponse.Translation translateContents(NaverRequest.Translation request);

    ServerResponse.DataLab getSearchTrend(NaverRequest.DataLab request);
}
