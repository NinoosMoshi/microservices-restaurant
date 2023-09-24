package com.ninos.service.impl;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.ninos.dto.RestaurantDTO;
import com.ninos.entity.Restaurant;
import com.ninos.mapper.RestaurantMapper;
import com.ninos.repository.RestaurantRepo;
import com.ninos.service.RestaurantService;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;
    private final RestaurantMapper restaurantMapper;


    @Override
    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> allRestaurants = restaurantRepo.findAll();
         return allRestaurants.stream().map(restaurant -> restaurantMapper.fromRestaurantToDTO(restaurant)).collect(Collectors.toList());
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantMapper.fromRestaurantDTOToRestaurant(restaurantDTO);
        Restaurant saved = restaurantRepo.save(restaurant);

        return restaurantMapper.fromRestaurantToDTO(saved);
    }


    @Override
    public RestaurantDTO findByRestaurantId(Long id) {
        Restaurant restaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("restaurant not found with id: " + id));
        return restaurantMapper.fromRestaurantToDTO(restaurant);
    }


}
