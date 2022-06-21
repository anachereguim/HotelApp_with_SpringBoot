package com.pizza.hotel.mapper;

import com.pizza.hotel.DTO.HotelDTO;
import com.pizza.hotel.entity.Hotel;
import com.pizza.hotel.request.HotelRequest;

public class HotelMapper {

    private HotelMapper() {}

    public static HotelDTO toDTO(Hotel hotel) {
        return HotelDTO.builder()
                .nome(hotel.getNome())
                .endereco(hotel.getEndereco())
                .build();
    }

    public static Hotel toHotel(HotelRequest request) {
        return Hotel.builder()
                .nome(request.getNome())
                .endereco(request.getEndereco())
                .build();
    }
}
