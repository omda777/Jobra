package com.omda.jobra.dto;

public record ContactRequestDto(
        String name,
        String email,
        String message,
        String subject,
        String userType) {
}
