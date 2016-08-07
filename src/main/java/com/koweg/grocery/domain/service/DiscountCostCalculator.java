/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.domain.service;

import com.koweg.grocery.domain.model.Fruit;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class DiscountCostCalculator implements CostCalculator {

    private static final int TWO_FOR_ONE = 2;
    private static final Integer THREE_FOR_TWO = 3;

    @Override
    public double calculateCost(Fruit fruit) {
        switch (fruit.getFruitType()) {
        case ORANGE:{
            return (fruit.getQuantity() * fruit.getFruitType().getUnitCost())
                    -(Integer.valueOf(fruit.getQuantity()/THREE_FOR_TWO)*fruit.getFruitType().getUnitCost());
        }
        case APPLE:{
            return (fruit.getQuantity() * fruit.getFruitType().getUnitCost())
                    -(Integer.valueOf(fruit.getQuantity()/TWO_FOR_ONE)*fruit.getFruitType().getUnitCost());
        }
        default:
            return 0;
        }
    }

}
