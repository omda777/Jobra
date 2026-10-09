package com.omda.jobra.company.service.impl;

import com.omda.jobra.dto.CompanyDto;
import com.omda.jobra.dto.JobDto;
import com.omda.jobra.entity.Company;
import com.omda.jobra.entity.Job;
import com.omda.jobra.repository.CompanyRepository;
import com.omda.jobra.company.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(this::companyToDto).collect(Collectors.toList());
    }

    private CompanyDto companyToDto(Company company) {
        List<JobDto> jobDtos = company.getJobs()
                .stream()
                .map(this::jobToDto)
                .collect(Collectors.toList());
        return new CompanyDto(
                company.getId() ,
                company.getName() ,
                company.getLogo(),
                company.getIndustry(),
                company.getSize(),
                company.getRating(),
                company.getLocations(),
                company.getFounded(),
                company.getDescription(),
                company.getEmployees(),
                company.getWebsite(),
                company.getCreatedAt(),
                jobDtos
        );
    }

    private JobDto jobToDto(Job job) {
        return new JobDto(
                job.getId(),
                job.getTitle(),
                job.getCompany().getId(),
                job.getCompany().getName(),
                job.getCompany().getLogo(),
                job.getLocation(),
                job.getWorkType(),
                job.getJobType(),
                job.getCategory(),
                job.getExperienceLevel(),
                job.getSalaryMin(),
                job.getSalaryMax(),
                job.getSalaryCurrency(),
                job.getSalaryPeriod(),
                job.getDescription(),
                job.getRequirements(),
                job.getBenefits(),
                job.getPostedDate(),
                job.getApplicationDeadline(),
                job.getApplicationsCount(),
                job.getFeatured(),
                job.getUrgent(),
                job.getRemote(),
                job.getStatus()
        );
    }
}
