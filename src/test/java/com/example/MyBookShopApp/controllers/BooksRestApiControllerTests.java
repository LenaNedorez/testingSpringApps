package com.example.MyBookShopApp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class BooksRestApiControllerTests {

    private final MockMvc mockMvc;

    @Autowired
    BooksRestApiControllerTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @Test
    void booksByAuthorTest() throws Exception {
        mockMvc.perform(get("/books/bestsellers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void priceRangeBooksTest() throws Exception {
        mockMvc.perform(get("/books/by-price-range"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void maxPriceBooksTest() throws Exception {
        mockMvc.perform(get("/books/with-max-discount"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void bestSellerBooksTest() throws Exception {
        mockMvc.perform(get("/books/bestsellers"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}