package com.colocation.services;

import com.colocation.models.ReviewModel;
import com.colocation.repositories.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements ReviewService {

    private final ReviewRepo reviewRepository;

    @Autowired
    public ReviewServiceImp(ReviewRepo reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ReviewModel createReview(ReviewModel review) {
        return null;
    }

    @Override
    public Optional<ReviewModel> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<ReviewModel> getAllReviews() {
        return reviewRepository.findAll();
    }


    @Override
    public ReviewModel updateReview(Long id, ReviewModel updatedReview) {
        return reviewRepository.findById(id)
                .map(existingReview -> {
                    existingReview.setRating(updatedReview.getRating());
                    existingReview.setComment(updatedReview.getComment());
                    existingReview.setDate(updatedReview.getDate());
                    return reviewRepository.save(existingReview);
                })
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }


    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }


}
