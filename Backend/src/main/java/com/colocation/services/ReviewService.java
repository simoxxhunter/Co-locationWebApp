package com.colocation.services;

import com.colocation.models.*;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    ReviewModel createReview(ReviewModel review);
    Optional<ReviewModel> getReviewById(Long id);
    List<ReviewModel> getAllReviews();
    ReviewModel updateReview(Long id, ReviewModel updatedReview);
    void deleteReview(Long id);
}
