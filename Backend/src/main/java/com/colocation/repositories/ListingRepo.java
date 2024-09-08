package com.colocation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.colocation.models.ListingsModel;

public interface ListingRepo extends JpaRepository<ListingsModel, Long> {
}
