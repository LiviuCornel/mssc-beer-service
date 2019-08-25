package com.example.msscbeerservice.mapper;

import com.example.msscbeerservice.persistence.Beer;
import com.example.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BeerMapper {

    Beer dtoToPo(BeerDto dto);
    BeerDto poToDto(Beer po);

}
