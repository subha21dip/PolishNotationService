package com.sinch.polishnotationservice;

import com.sinch.polishnotationservice.exception.UnsupportedOperatorException;
import com.sinch.polishnotationservice.manager.ExpressionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionManagerTest {

    private ExpressionManager manager = new ExpressionManager();


    @Test
    @DisplayName("Valid operator")
    void testCalculateSuccess() throws UnsupportedOperatorException {
        assertEquals(8.0, manager.calculate(2, 6, '+', 1),
                "Got addition of two values");
    }

    @Test
    @DisplayName("Invalid operator")
    void testCalculateFailure() throws UnsupportedOperatorException {
        Assertions.assertThrows(UnsupportedOperatorException.class, () -> {
            manager.calculate(2, 6, '.', 1);
        });

    }

}
