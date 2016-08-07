/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.service;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.koweg.grocery.domain.model.Fruit;
import com.koweg.grocery.domain.model.FruitType;
import com.koweg.grocery.domain.service.CostCalculator;
import com.koweg.grocery.domain.service.DiscountCostCalculator;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class DiscountCostCalculatorTest {

    private CostCalculator discountCostCalculator;

    @Before
    public void setUp() throws Exception {
        discountCostCalculator = new DiscountCostCalculator();
    }

    @Test
    public void shouldCalculateExpectedDiscountedCostOfTwoApples() {
        assertThat(BigDecimal.valueOf(discountCostCalculator.calculateCost(new Fruit(FruitType.APPLE, 2))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(0.60d));
    }

    @Test
    public void shouldCalculateExpectedDiscountedCostOfThreeApples() {
        assertThat(BigDecimal.valueOf(discountCostCalculator.calculateCost(new Fruit(FruitType.APPLE, 3))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(1.20d));
    }

    @Test
    public void shouldCalculateExpectedDiscountedCostOfThreeOranges() {
        assertThat(BigDecimal.valueOf(discountCostCalculator.calculateCost(new Fruit(FruitType.ORANGE, 3))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(0.50d));
    }

    @Test
    public void shouldCalculateExpectedDiscountedCostOfFiveOranges() {
        assertThat(BigDecimal.valueOf(discountCostCalculator.calculateCost(new Fruit(FruitType.ORANGE, 5))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(1.0d));
    }
    @Test
    public void shouldCalculateExpectedDiscountedCostOfNineOranges() {
        assertThat(BigDecimal.valueOf(discountCostCalculator.calculateCost(new Fruit(FruitType.ORANGE, 9))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(1.5d));
    }


}
