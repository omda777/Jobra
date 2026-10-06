package com.omda.jobra.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ContactRequestDto(
        @NotBlank(message = "name can't be empty")
        String name,

        @NotBlank(message = "email can't be empty")
        @Email(message = "Invalid Email address")
        String email,

        @NotBlank(message = "message can't be empty")
        @Size(min = 5 , max = 500 , message = "message should be between 5 and 500 character")
        String message,

        @NotBlank(message = "subject can't be empty")
        String subject,

        @NotBlank(message = "userType can't be empty")
        @Pattern(regexp = "Job Seeker|Employer|Other" , message = "userType must be one of this value Job Seeker, Employer, Other")
        String userType

        ) {
}
