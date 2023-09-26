package com.ninos.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ninos.dto.FoodItemDTO;
import com.ninos.entity.FoodItem;

@Service
public class FoodItemMapper {

    public FoodItemDTO fromFoodItemToFoodItemDTO(FoodItem foodItem){
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        BeanUtils.copyProperties(foodItem, foodItemDTO);
        return foodItemDTO;
    }



    public FoodItem fromFoodItemDTOToFood(FoodItemDTO foodItemDTO){
        FoodItem foodItem = new FoodItem();
        BeanUtils.copyProperties(foodItemDTO, foodItem);
        return foodItem;
    }


}
