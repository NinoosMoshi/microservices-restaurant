package com.ninos.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.dto.FoodItemDTO;
import com.ninos.service.FoodCatalogueService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    private final FoodCatalogueService foodCatalogueService;


    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItemDTO1 = foodCatalogueService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItemDTO1, HttpStatus.CREATED);
    }



}
