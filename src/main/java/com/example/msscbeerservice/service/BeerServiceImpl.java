package com.example.msscbeerservice.service;

import com.example.msscbeerservice.mapper.BeerMapper;
import com.example.msscbeerservice.persistence.Beer;
import com.example.msscbeerservice.repository.BeerRepository;
import com.example.msscbeerservice.web.model.BeerDto;
import com.example.msscbeerservice.web.model.BeerPagedList;
import com.example.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BeerMapper beerMapper;

    @Override
    public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest of, Boolean showInventoryOnHand) {
        return null;
    }

    @Override
    public BeerDto getById(UUID beerId, Boolean showInventoryOnHand) {
        Optional<Beer> optionalBeer = beerRepository.findById(beerId);

        BeerDto beerDto;

        if(optionalBeer.isPresent()){
            beerDto = beerMapper.poToDto(optionalBeer.get());
            return beerDto;
        }else{
            return null;
        }
    }

    @Override
    public BeerDto getByUpc(String upc) {
        return null;
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        Beer beer = beerMapper.dtoToPo(beerDto);
        return beerMapper.poToDto(beerRepository.save(beer));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {

        return null;
    }
}
