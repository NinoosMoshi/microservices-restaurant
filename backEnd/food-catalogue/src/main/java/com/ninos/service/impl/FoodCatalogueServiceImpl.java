package com.ninos.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.ninos.dto.FoodItemDTO;
import com.ninos.entity.FoodItem;
import com.ninos.mapper.FoodItemMapper;
import com.ninos.repository.FoodItemRepo;
import com.ninos.service.FoodCatalogueService;

@RequiredArgsConstructor
@Service
public class FoodCatalogueServiceImpl implements FoodCatalogueService {

    private final FoodItemRepo foodItemRepo;
    private final FoodItemMapper foodItemMapper;


    @Override
    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = foodItemMapper.fromFoodItemDTOToFood(foodItemDTO);
        FoodItem savedFoodItem = foodItemRepo.save(foodItem);

        return foodItemMapper.fromFoodItemToFoodItemDTO(savedFoodItem);
    }
}
