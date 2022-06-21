package com.pizza.hotel.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer idade;

    private Integer visitas;

    private String email;

    @OneToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "quarto_id", referencedColumnName = "id")
    private Quarto quarto;

    public void addHotel(Hotel hotel) {
        setHotel(hotel);
        hotel.setPessoa(this);
    }

    public void addQuarto(Quarto quarto) {
        setQuarto(quarto);
        quarto.getPessoas().add(this);
    }
}
