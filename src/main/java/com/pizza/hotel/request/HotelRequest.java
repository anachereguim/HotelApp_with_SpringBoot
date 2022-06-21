package com.pizza.hotel.request;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequest {

    @NotNull
    @ApiModelProperty(notes = "Name of hotel", required = true)
    private String nome;

    @NotNull
    @ApiModelProperty(notes = "Address of hotel", required = true)
    private String endereco;
}
