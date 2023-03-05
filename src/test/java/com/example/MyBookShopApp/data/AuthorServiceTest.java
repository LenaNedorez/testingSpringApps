package com.example.MyBookShopApp.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AuthorServiceTest {

    @MockBean
    private JdbcTemplate jdbcTemplateMock;
    private AuthorService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AuthorService(jdbcTemplateMock);
    }

    @Test
    void getAuthorsMap() {
        Map<String, List<Author>> authorsMap = underTest.getAuthorsMap();
        assertNotNull(authorsMap);
    }
}