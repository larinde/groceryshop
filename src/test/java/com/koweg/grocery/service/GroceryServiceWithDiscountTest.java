/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.service;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.koweg.grocery.domain.model.FruitType;
import com.koweg.grocery.domain.service.DiscountCostCalculator;
import com.koweg.grocery.domain.service.GroceryService;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class GroceryServiceWithDiscountTest {

    private GroceryService service;

    @Before
    public void setup() {
         service = new GroceryService(new DiscountCostCalculator());
    }

    @Test
    public void shouldCalculateExpectedDiscountedCostOfOneAppleItem() {
        assertThat(service.totalCost(Arrays.asList("apple")), equalTo(FruitType.APPLE.getUnitCost()));
    }

    @Test
    public void shouldCalculateExpectedDiscountedCostOfThreeAppleItems() {
        assertThat(BigDecimal.valueOf(service.totalCost(Arrays.asList("apple", "apple", "apple"))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(1.20d));
    }

    @Test
    public void shouldCalculateExpectedCostOfOneOrangeItem() {
        assertThat(service.totalCost(Arrays.asList("orange")), equalTo(FruitType.ORANGE.getUnitCost()));
    }

    @Test
    public void shouldCalculateExpectedDiscountedCostOfSevenOrangeItems() {
        int numOranges = 7;
        int numApples = 0;
        assertThat(service.totalCost(generateItems(numApples, numOranges)), equalTo(1.25d));
    }

    @Test
    public void shouldCalculateExpectedCostOfThreeAppleAndOneOrangeItems() {
        int numApples = 3;
        int numOranges = 1;
        assertThat(BigDecimal.valueOf(service.totalCost(generateItems(numApples, numOranges))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(1.45d));
    }

    @Test
    public void shouldCalculateExpectedCostOfTwoAppleAndThreeOrangeItems() {
        int numApples = 2;
        int numOranges = 3;
        assertThat(BigDecimal.valueOf(service.totalCost(generateItems(numApples, numOranges))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(1.10d));
    }

    private List<String> generateItems(int numApples, int numOranges){
        List<String>items = new ArrayList<>(numApples + numOranges);
        for (int i = 0; i < numApples; i++) {
            items.add(FruitType.APPLE.name());
        }
        for (int i = 0; i < numOranges; i++) {
            items.add(FruitType.ORANGE.name());
        }
        return items;
    }

}
