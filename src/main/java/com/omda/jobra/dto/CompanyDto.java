package com.omda.jobra.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record CompanyDto(long id, String name, String logo, String industry, String size, BigDecimal rating,
                         String locations, int founded, String  description, Integer employees, String website,
                         Instant createdAt ) {
}
