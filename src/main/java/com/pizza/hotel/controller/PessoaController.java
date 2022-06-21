package com.pizza.hotel.controller;


import com.pizza.hotel.DTO.ErrorDTO;
import com.pizza.hotel.DTO.PessoaQuartoDTO;
import com.pizza.hotel.entity.Pessoa;
import com.pizza.hotel.request.PessoaRequest;
import com.pizza.hotel.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(tags = "Pessoa Controller", consumes = "application/json")
@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public List<PessoaQuartoDTO> getPessoas() {
        return pessoaService.getAll();
    }

    @ApiOperation(value = "Create a new Person", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created the person"),
            @ApiResponse(code = 404, message = "Hotel or room not found", response = ErrorDTO.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PessoaQuartoDTO> create(@RequestBody @Validated PessoaRequest request) {
        PessoaQuartoDTO pessoa = pessoaService.create(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/pessoa/{id}")
                .buildAndExpand(pessoa.getHotelId())
                .toUri();

        return ResponseEntity.created(uri).body(pessoa);
    }

}
