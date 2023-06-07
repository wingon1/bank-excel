package com.example.excel.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestServiceTest {

    @Autowired
    TestService testService;

    @Test
    void getTest() {
        assertEquals(testService.getTest(), "test");
    }

    @Test
    void 예외가_발생하지_않음() {
        Assertions.assertDoesNotThrow(() -> {
            testService.readTestExcelFile("KB");
        });
    }
}