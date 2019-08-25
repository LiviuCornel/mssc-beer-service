package com.example.msscbeerservice.bootstrap;

import com.example.msscbeerservice.persistence.Beer;
import com.example.msscbeerservice.repository.BeerRepository;
import com.example.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    BeerRepository beerRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Beer beer = new Beer();
        beer.setBeerName("prima birra");
        beer.setBeerStyle(BeerStyleEnum.ALE);
        beerRepository.save(beer);

    }

}
