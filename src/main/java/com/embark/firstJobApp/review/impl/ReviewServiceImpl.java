package com.embark.firstJobApp.review.impl;

import com.embark.firstJobApp.company.Company;
import com.embark.firstJobApp.company.CompanyService;
import com.embark.firstJobApp.review.Review;
import com.embark.firstJobApp.review.ReviewRepository;
import com.embark.firstJobApp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public void addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
        }
    }
}
