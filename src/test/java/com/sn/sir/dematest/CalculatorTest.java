package com.sn.sir.dematest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    // Calculator calculator;
    @BeforeEach
    void setUp() {
        // calculator = new Calculator();
    }

    @Test
    void sum() {
        // Given
        Calculator calculator = new Calculator();
        int a = 3;
        int b = 4;
        // When
        int result = calculator.sum(a, b);
        // Then
        assertEquals(7, result);
    }

    @Test
    void sub() {
        // Given
        Calculator calculator = new Calculator();
        // When
        int result = calculator.sub(3, 2);
        // Then
        assertEquals(1, result);
    }

    @Test
    void mul() {
        // Given
        Calculator calculator = new Calculator();
        // When
        int result = calculator.mul(3, 2);
        // Then
        assertEquals(6, result);
    }

    @Test
    void div() {
        // Given
        Calculator calculator = new Calculator();
        // When
        int result = calculator.div(3, 2);
        // Then
        assertEquals(1, result);
    }
}