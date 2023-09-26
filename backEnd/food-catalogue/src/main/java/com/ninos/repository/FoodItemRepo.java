package com.ninos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninos.entity.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findByRestaurantId(Long restaurantId);

}
