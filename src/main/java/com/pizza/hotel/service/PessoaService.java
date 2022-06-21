package com.pizza.hotel.service;

import com.pizza.hotel.DTO.PessoaQuartoDTO;
import com.pizza.hotel.entity.Hotel;
import com.pizza.hotel.entity.Pessoa;
import com.pizza.hotel.entity.Quarto;
import com.pizza.hotel.exception.HotelNotFoundException;
import com.pizza.hotel.exception.QuartoNotFoundException;
import com.pizza.hotel.mapper.PessoaMapper;
import com.pizza.hotel.repository.HotelRepository;
import com.pizza.hotel.repository.PessoaRepository;
import com.pizza.hotel.repository.QuartoRepository;
import com.pizza.hotel.request.PessoaRequest;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final HotelRepository hotelRepository;
    private final QuartoRepository quartoRepository;

    public List<PessoaQuartoDTO> getAll() {
        return pessoaRepository.findAll().stream()
                .map(PessoaMapper::toPessoaQuartoDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PessoaQuartoDTO create(PessoaRequest request) {
        Hotel hotel = hotelRepository.findById(request.getHotelId())
                .orElseThrow(() -> new HotelNotFoundException("Hotel with id " + request.getHotelId() + " does not exist"));

        Optional<Quarto> quarto = (request.getVisitas()>10) ? quartoRepository.findByCodigo("V") : quartoRepository.findByCodigo("C");



        Pessoa newPessoa = pessoaRepository.save(PessoaMapper.toPessoa(request));

        newPessoa.addHotel(hotel);
        if(quarto.isEmpty()){
            throw new QuartoNotFoundException("Room with code" + request.getQuartoCodigo() + " does not exist");
        }
        newPessoa.addQuarto(quarto.get());

        return PessoaMapper.toPessoaQuartoDTO(newPessoa);
    }

}
