package com.openapi.papago.translation.service;


import com.openapi.papago.translation.dto.Request;
import com.openapi.papago.translation.dto.Response;

public interface TranslationService {

    Response.Translation translateContents(Request.Translation request);
}
