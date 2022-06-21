package com.pizza.hotel.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private String nome;
    private Integer idade;
    private Integer visitas;
    private String email;
    private Long hotelId;
}
