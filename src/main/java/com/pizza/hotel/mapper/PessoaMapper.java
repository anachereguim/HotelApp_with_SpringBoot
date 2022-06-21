package com.pizza.hotel.mapper;

import com.pizza.hotel.DTO.PessoaDTO;
import com.pizza.hotel.DTO.PessoaQuartoDTO;
import com.pizza.hotel.entity.Pessoa;
import com.pizza.hotel.request.PessoaRequest;


public class PessoaMapper {

    private PessoaMapper() {}

    public static PessoaDTO toDTO(Pessoa pessoa) {
        return PessoaDTO.builder()
                .nome(pessoa.getNome())
                .idade(pessoa.getIdade())
                .visitas(pessoa.getVisitas())
                .email(pessoa.getEmail())
                .hotelId(pessoa.getHotel().getId())
                .build();
    }

    public static PessoaQuartoDTO toPessoaQuartoDTO(Pessoa pessoa) {
        return PessoaQuartoDTO.builder()
                .nome(pessoa.getNome())
                .idade(pessoa.getIdade())
                .visitas(pessoa.getVisitas())
                .email(pessoa.getEmail())
                .hotelId(pessoa.getHotel().getId())
                .quarto(QuartoMapper.toDTO(pessoa.getQuarto()))
                .build();
    }
    public static Pessoa toPessoa(PessoaRequest request) {
        return Pessoa.builder()
                .nome(request.getNome())
                .idade(request.getIdade())
                .visitas(request.getVisitas())
                .email(request.getEmail())
                .build();
    }

}
