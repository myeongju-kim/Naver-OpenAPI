package com.openapi.papago.translation.controller;

import com.openapi.papago.translation.dto.Request;
import com.openapi.papago.translation.dto.Response;
import com.openapi.papago.translation.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/translation")
public class TranslationController {

    private final TranslationService translationService;

    @PostMapping
    public ResponseEntity<Response.Translation> translateContents(@RequestBody Request.Translation request) {

        return ResponseEntity.status(HttpStatus.OK)
                             .body(translationService.translateContents(request));
    }
}
