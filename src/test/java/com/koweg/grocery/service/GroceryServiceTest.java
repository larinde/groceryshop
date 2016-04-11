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

import com.koweg.grocery.domain.exception.GroceryShopException;
import com.koweg.grocery.domain.model.FruitType;
import com.koweg.grocery.domain.service.GroceryService;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class GroceryServiceTest {

    private GroceryService service;

    @Before
    public void setup() {
         service = new GroceryService(new BasicCostCalculator());
    }

    @Test
    public void shouldCalculateExpectedCostOfOneAppleItem() {
        assertThat(service.totalCost(Arrays.asList("apple")), equalTo(FruitType.APPLE.getUnitCost()));
    }

    @Test
    public void shouldCalculateExpectedCostOfThreeAppleItems() {
        assertThat(BigDecimal.valueOf(service.totalCost(Arrays.asList("apple", "apple", "apple"))).setScale(2, RoundingMode.UP).doubleValue(), equalTo(1.80d));
    }

    @Test(expected = GroceryShopException.class)
    public void shouldThrowExceptionForInvalidItem() {
        service.totalCost(Arrays.asList("apple", "unknowItem"));
    }

    @Test
    public void shouldCalculateExpectedCostOfOneOrangeItem() {
        assertThat(service.totalCost(Arrays.asList("orange")), equalTo(FruitType.ORANGE.getUnitCost()));
    }

    @Test
    public void shouldCalculateExpectedCostOfSevenOrangeItems() {
        int numOranges = 7;
        int numApples = 0;
        assertThat(service.totalCost(generateItems(numApples, numOranges)), equalTo(1.75d));
    }

    @Test
    public void shouldCalculateExpectedCostOfThreeAppleAndOneOrangeItems() {
        int numApples = 3;
        int numOranges = 1;
        assertThat(service.totalCost(generateItems(numApples, numOranges)), equalTo(2.05d));
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
