package com.pizza.hotel.mapper;

import com.pizza.hotel.DTO.QuartoDTO;
import com.pizza.hotel.DTO.QuartoPessoaDTO;
import com.pizza.hotel.entity.Quarto;
import com.pizza.hotel.request.QuartoRequest;

import java.util.stream.Collectors;

public class QuartoMapper {

    private QuartoMapper() {}

    public static QuartoDTO toDTO(Quarto quarto) {
        return QuartoDTO.builder()
                .codigo(quarto.getCodigo())
                .nome(quarto.getNome())
                .build();
    }

    public static QuartoPessoaDTO toQuartoPessoaDTO(Quarto quarto) {
        return QuartoPessoaDTO.builder()
                .nome(quarto.getNome())
                .codigo(quarto.getCodigo())
                .pessoas(quarto.getPessoas().stream().map(PessoaMapper::toDTO).collect(Collectors.toList()))
                .build();
    }

    public static Quarto toQuarto(QuartoRequest request) {
        return Quarto.builder()
                .nome(request.getNome())
                .codigo(request.getCodigo())
                .build();
    }
}
