/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Before;
import org.junit.Test;

import com.koweg.grocery.domain.model.Fruit;
import com.koweg.grocery.domain.model.FruitType;
import com.koweg.grocery.domain.service.BasicCostCalculator;
import com.koweg.grocery.domain.service.CostCalculator;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class BasicCostCalculatorTest {

    private CostCalculator calculator;

    @Before
    public void setup() {
        calculator = new BasicCostCalculator();
    }



    @Test
    public void shouldCalculateExpectedCostOfZeroApple() {
        assertThat(calculator.calculateCost(new Fruit(FruitType.APPLE, 0)), equalTo(0.0d));
    }

    @Test
    public void shouldCalculateExpectedCostOfOneApple() {
        assertThat(calculator.calculateCost(new Fruit(FruitType.APPLE, 1)), equalTo(0.6d));
    }

    @Test
    public void shouldCalculateExpectedCostOfThreeApples() {
        assertThat(BigDecimal.valueOf(calculator.calculateCost(new Fruit(FruitType.APPLE, 3))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(1.80d));
    }

    @Test
    public void shouldCalculateExpectedCostOfOneOrange() {
        assertThat(calculator.calculateCost(new Fruit(FruitType.ORANGE, 1)), equalTo(0.25d));
    }

    @Test
    public void shouldCalculateExpectedCostOfSevenOranges() {
        assertThat(calculator.calculateCost(new Fruit(FruitType.ORANGE, 7)), equalTo(1.75d));
    }





}
