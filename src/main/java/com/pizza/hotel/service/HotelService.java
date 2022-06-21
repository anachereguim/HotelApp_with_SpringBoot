package com.pizza.hotel.service;

import com.pizza.hotel.DTO.HotelDTO;
import com.pizza.hotel.entity.Hotel;
import com.pizza.hotel.mapper.HotelMapper;
import com.pizza.hotel.repository.HotelRepository;
import com.pizza.hotel.request.HotelRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<HotelDTO> getAll() {
        return hotelRepository.findAll().stream()
                .map(HotelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Hotel create(HotelRequest request) {
        return hotelRepository.save(HotelMapper.toHotel(request));
    }
}
