package com.jumpstart.food_ordering_system.repository;

import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.entity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * Repository interface for Menu entity.
 * Provides database operations
 */
public interface MenuRepository extends  JpaRepository<Menu,Long> {

    List<Menu> findByCategoryId(Long categoryId);
    boolean existsByCategory(Category category);
    List<Menu> findByNameContainingIgnoreCase(String search);
}
