package com.jumpstart.food_ordering_system.repository;

import com.jumpstart.food_ordering_system.entity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Repository interface for Menu entity.
 * Provides database operations
 */
public interface MenuRepository extends  JpaRepository<Menu,Long> {

}
