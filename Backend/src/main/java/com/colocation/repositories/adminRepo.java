package com.colocation.repositories;

import com.colocation.models.adminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface adminRepo extends JpaRepository<adminModel, Long> {
}
