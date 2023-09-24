package com.ninos.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ninos.dto.RestaurantDTO;
import com.ninos.entity.Restaurant;

@Service
public class RestaurantMapper {

    public RestaurantDTO fromRestaurantToDTO(Restaurant restaurant){
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        BeanUtils.copyProperties(restaurant, restaurantDTO);
        return restaurantDTO;
    }


    public Restaurant fromRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO){
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantDTO, restaurant);
        return restaurant;
    }


}
