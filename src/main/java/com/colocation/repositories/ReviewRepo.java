package com.colocation.repositories;

import com.colocation.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<ReviewModel, Long> {
}
