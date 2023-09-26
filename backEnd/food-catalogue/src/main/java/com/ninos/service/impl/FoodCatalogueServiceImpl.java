package com.ninos.service.impl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ninos.dto.FoodCataloguePage;
import com.ninos.dto.FoodItemDTO;
import com.ninos.dto.Restaurant;
import com.ninos.entity.FoodItem;
import com.ninos.mapper.FoodItemMapper;
import com.ninos.repository.FoodItemRepo;
import com.ninos.service.FoodCatalogueService;

@RequiredArgsConstructor
@Service
public class FoodCatalogueServiceImpl implements FoodCatalogueService {

    private final FoodItemRepo foodItemRepo;
    private final FoodItemMapper foodItemMapper;
    private final RestTemplate restTemplate;


    @Override
    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = foodItemMapper.fromFoodItemDTOToFood(foodItemDTO);
        FoodItem savedFoodItem = foodItemRepo.save(foodItem);
        return foodItemMapper.fromFoodItemToFoodItemDTO(savedFoodItem);
    }


    @Override
    public FoodCataloguePage fetchFoodCataloguePageDetails(Long restaurantId) {
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }


    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Long restaurantId) {
        return  restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/" + restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Long restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}
