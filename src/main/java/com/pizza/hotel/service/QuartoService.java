package com.pizza.hotel.service;

import com.pizza.hotel.DTO.QuartoPessoaDTO;
import com.pizza.hotel.entity.Quarto;
import com.pizza.hotel.mapper.QuartoMapper;
import com.pizza.hotel.repository.QuartoRepository;
import com.pizza.hotel.request.QuartoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuartoService {
    private final QuartoRepository quartoRepository;

    public List<QuartoPessoaDTO> getAll() {
        return quartoRepository.findAll().stream()
                .map(QuartoMapper::toQuartoPessoaDTO)
                .collect(Collectors.toList());
    }

    public Quarto create(QuartoRequest request) {
        return quartoRepository.save(QuartoMapper.toQuarto(request));
    }
}
