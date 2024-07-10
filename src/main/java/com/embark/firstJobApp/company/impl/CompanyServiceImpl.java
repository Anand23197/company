package com.embark.firstJobApp.company.impl;

import com.embark.firstJobApp.company.Company;
import com.embark.firstJobApp.company.CompanyRepository;
import com.embark.firstJobApp.company.CompanyService;
import com.embark.firstJobApp.job.Job;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company2update = companyOptional.get();
            company2update.setDescription(company.getDescription());
            company2update.setName(company.getName());
            company2update.setJobs(company.getJobs());
            companyRepository.save(company2update);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public Company getCompanyById(@PathVariable Long id) {
        return companyRepository.findById(id).orElse(null);
    }

}