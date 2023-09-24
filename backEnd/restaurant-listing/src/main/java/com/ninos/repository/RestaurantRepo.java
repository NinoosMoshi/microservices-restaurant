package com.ninos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninos.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
}
