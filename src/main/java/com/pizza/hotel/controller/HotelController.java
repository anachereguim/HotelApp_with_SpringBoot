package com.pizza.hotel.controller;


import com.pizza.hotel.DTO.HotelDTO;
import com.pizza.hotel.entity.Hotel;
import com.pizza.hotel.request.HotelRequest;
import com.pizza.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hotel")
@Validated
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getHotel() {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
    }

    @PostMapping
    public Hotel addHotel (@RequestBody @Validated HotelRequest request) {
        return hotelService.create(request);
    }
}
