package com.openapi.papago.naver.controller;

import com.openapi.papago.naver.dto.NaverRequest;
import com.openapi.papago.naver.dto.ServerResponse;
import com.openapi.papago.naver.service.NaverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/naver")
public class NaverController {

    private final NaverService naverService;

    @PostMapping("/translation")
    public ResponseEntity<ServerResponse.Translation> translateContents(@RequestBody NaverRequest.Translation request) {

        return ResponseEntity.status(HttpStatus.OK)
                             .body(naverService.translateContents(request));
    }

    @PostMapping("/datalab")
    public ResponseEntity<ServerResponse.DataLab> getSearchTrend(@RequestBody NaverRequest.DataLab request) {

        return ResponseEntity.status(HttpStatus.OK)
                             .body(naverService.getSearchTrend(request));
    }
}
