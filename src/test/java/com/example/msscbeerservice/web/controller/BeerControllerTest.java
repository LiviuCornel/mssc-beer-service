package com.example.msscbeerservice.web.controller;

import com.example.msscbeerservice.mapper.BeerMapper;
import com.example.msscbeerservice.repository.BeerRepository;
import com.example.msscbeerservice.service.BeerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerServiceImpl;

    @MockBean
    BeerController beerController;

    @MockBean
    BeerRepository beerRepository;

    @MockBean
    BeerMapper beerMapper;

    @Test
    void listBeers() {
    }

    @Test
    void getBeerById()throws Exception {
        mockMvc
                .perform(get("/api/v1/beer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getBeerByUpc() {
    }

    @Test
    void saveNewBeer() {
    }

    @Test
    void updateBeerById() {
    }
}