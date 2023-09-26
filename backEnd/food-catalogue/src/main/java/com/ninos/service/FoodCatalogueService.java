package com.ninos.service;

import com.ninos.dto.FoodCataloguePage;
import com.ninos.dto.FoodItemDTO;

public interface FoodCatalogueService {

    FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO);
    FoodCataloguePage fetchFoodCataloguePageDetails(Long restaurantId);

}
