package com.pizza.hotel.request;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaRequest {

    @NotNull
    private String nome;

    @NotNull
    @Min(18)
    @Max(100)
    private Integer idade;

    @NotNull
    private Integer visitas;
    @NotNull
    private String email;

    @NotNull
    private Long hotelId;


    private String quartoCodigo;
}
