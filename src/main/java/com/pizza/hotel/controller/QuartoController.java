package com.pizza.hotel.controller;


import com.pizza.hotel.DTO.QuartoPessoaDTO;
import com.pizza.hotel.entity.Quarto;
import com.pizza.hotel.request.QuartoRequest;
import com.pizza.hotel.service.QuartoService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quarto")
@Validated
public class QuartoController {

    private final QuartoService quartoService;

    @GetMapping
    public List<QuartoPessoaDTO> getPessoas() {
        return quartoService.getAll();
    }

    @PostMapping
    public Quarto create(@RequestBody @Validated QuartoRequest request) {
        return quartoService.create(request);
    }
}
