package com.colocation.controllers;

import com.colocation.models.ReviewModel;
import com.colocation.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ReviewModel createReview(@RequestBody ReviewModel review) {
        return reviewService.createReview(review);
    }

    @GetMapping("/{id}")
    public ReviewModel getReviewById(@PathVariable Long id) {
        Optional<ReviewModel> review = reviewService.getReviewById(id);
        return review.orElse(null);
    }

    @GetMapping
    public List<ReviewModel> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PutMapping("/{id}")
    public ReviewModel updateReview(@PathVariable Long id, @RequestBody ReviewModel updatedReview) {
        Optional<ReviewModel> existingReview = reviewService.getReviewById(id);
        if (existingReview.isPresent()) {
            return reviewService.updateReview(id, updatedReview);
        } else {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
