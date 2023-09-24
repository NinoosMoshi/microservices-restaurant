package com.ninos.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.dto.RestaurantDTO;
import com.ninos.service.RestaurantService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
       List<RestaurantDTO> restaurantDTOS = restaurantService.findAllRestaurants();
       return new ResponseEntity<>(restaurantDTOS, HttpStatus.OK);
    }


    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }



    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Long id){
        RestaurantDTO restaurantDTO = restaurantService.findByRestaurantId(id);
        return ResponseEntity.ok(restaurantDTO);
    }




}
