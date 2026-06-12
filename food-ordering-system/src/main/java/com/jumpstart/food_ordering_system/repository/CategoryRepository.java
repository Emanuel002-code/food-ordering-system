package com.jumpstart.food_ordering_system.repository;

import com.jumpstart.food_ordering_system.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


/**
  CategoryRepository class responsible for database operations
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
