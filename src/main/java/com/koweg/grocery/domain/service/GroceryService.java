/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.koweg.grocery.domain.exception.GroceryShopException;
import com.koweg.grocery.domain.model.Apple;
import com.koweg.grocery.domain.model.Fruit;
import com.koweg.grocery.domain.model.FruitType;
import com.koweg.grocery.domain.model.Orange;
import com.koweg.grocery.service.BasicCostCalculator;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class GroceryService {

    private final CostCalculator calculator;

    public GroceryService(CostCalculator calculator) {
        this.calculator = calculator;
    }

    public double totalCost(final List<String> items) {
        List<Fruit> shoppingCart = loadShoppingCart(items);
        return calculateCost(shoppingCart);
    }

    private double calculateCost(final List<Fruit> shoppingCart) {
        double totalCost = 0;
        for (Fruit fruit : shoppingCart) {
            totalCost += fruit.getCost(calculator);
        }
        return totalCost;
    }

    private List<Fruit> loadShoppingCart(final List<String> items) {
        try {
            Map<FruitType, Integer> cart = new HashMap<>();
            for (String item : items) {
                FruitType fruitType = FruitType.valueOf(item.toUpperCase());
                if (cart.containsKey(fruitType)) {
                    cart.put(fruitType, cart.get(fruitType).intValue() + 1);
                } else {
                    cart.put(fruitType, Integer.valueOf(1));
                }
            }

            List<Fruit> _cart = new ArrayList<>();
            for (Entry<FruitType, Integer> item : cart.entrySet()) {
                if (item.getKey().equals(FruitType.APPLE)) {
                    _cart.add(new Apple(item.getValue()));
                }
                if (item.getKey().equals(FruitType.ORANGE)) {
                    _cart.add(new Orange(item.getValue()));
                }
            }
            return Collections.unmodifiableList(_cart);
        } catch (Exception e) {
            throw new GroceryShopException("invalid or unknown item");
        }
    }

    public static void main(String[] args) {
        CostCalculator basicCostCalculator = new BasicCostCalculator();
        GroceryService groceryService = new GroceryService(basicCostCalculator);
        try {
            double totalCost = groceryService.totalCost(Arrays.asList(args));
            System.out.println("Total Cost = £" + BigDecimal.valueOf(totalCost).setScale(2, RoundingMode.UP).doubleValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
