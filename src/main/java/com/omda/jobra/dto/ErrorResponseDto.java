package com.omda.jobra.dto;

import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        HttpStatusCode httpStatusCode,
        String message,
        String apiPath,
        LocalDateTime errorTime){
}
