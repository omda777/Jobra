package com.omda.jobra.company.service.impl;

import com.omda.jobra.dto.CompanyDto;
import com.omda.jobra.entity.Company;
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
        return companies.stream().map(this::toDto).collect(Collectors.toList());
    }

    private CompanyDto toDto(Company company) {
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
                company.getCreatedAt()
        );
    }
}
