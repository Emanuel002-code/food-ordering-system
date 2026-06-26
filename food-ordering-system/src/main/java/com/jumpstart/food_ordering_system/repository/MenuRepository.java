package com.jumpstart.food_ordering_system.repository;

import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.entity.Menu;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * Repository interface for Menu entity.
 * Provides database operations
 */
public interface MenuRepository extends  JpaRepository<Menu,Long> {

    Page<Menu> findByCategoryId(Long categoryId, Pageable pageable);
    boolean existsByCategory(Category category);
    Page<Menu> findByNameContainingIgnoreCase(String search, Pageable pageable);
    Page<Menu> findByCategoryIdAndNameContainingIgnoreCase(Long categoryId, String search, Pageable pageable);

}
