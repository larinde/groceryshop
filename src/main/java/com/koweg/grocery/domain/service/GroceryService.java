/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.koweg.grocery.domain.model.Fruit;
import com.koweg.grocery.domain.model.FruitType;

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
//        List<AbstractFruit> shoppingCart = loadShoppingCart(items);
        List<Fruit> shoppingCart = collate(items);
        return calculateCost(shoppingCart);
    }


    private double calculateCost(final List<Fruit> shoppingCart) {
        return shoppingCart.stream().mapToDouble(tot -> tot.getCost(calculator)).sum();
    }

    public List<Fruit> collate(List<String> items) {

        Map<String, List<FruitType>> collatedItems = items.stream()
        .map(String::toUpperCase)
        .map(fr -> FruitType.valueOf(fr))
        .collect(Collectors.groupingBy(FruitType::name));

        List<Fruit>result = new ArrayList<>();
        collatedItems.forEach((k, v) -> {result.add(new Fruit(FruitType.valueOf(k), v.size()));});
        return result;

    }

    public static void main(String[] args) {
        CostCalculator costCalculator = new DiscountCostCalculator();
        GroceryService groceryService = new GroceryService(costCalculator);
        try {
            double totalCost = groceryService.totalCost(Arrays.asList(args));
            System.out.println("Total Cost = £" + BigDecimal.valueOf(totalCost).setScale(2, RoundingMode.UP).doubleValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
