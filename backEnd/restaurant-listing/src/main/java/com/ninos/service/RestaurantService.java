package com.ninos.service;

import java.util.List;

import com.ninos.dto.RestaurantDTO;

public interface RestaurantService {

    List<RestaurantDTO> findAllRestaurants();
    RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO);
    RestaurantDTO findByRestaurantId(Long id);
}
