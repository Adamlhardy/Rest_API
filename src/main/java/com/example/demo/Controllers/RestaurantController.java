package com.example.demo.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.Models.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositories.RestaurantRepository;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    
    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping("/{borough}")
    public ResponseEntity<List<Restaurant>> getRestaurantByBorough(@PathVariable(value = "borough") String boroughName) {
       
        List<Restaurant>result = restaurantRepository.findRestaurantByBorough(boroughName);
       
        if(result != null) {
        return ResponseEntity.ok(result);
       } else {
        return ResponseEntity.notFound().build();
       }
    }
}
