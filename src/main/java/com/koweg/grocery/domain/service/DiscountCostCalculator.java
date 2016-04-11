/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.domain.service;

import com.koweg.grocery.domain.model.Apple;
import com.koweg.grocery.domain.model.FruitType;
import com.koweg.grocery.domain.model.Orange;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class DiscountCostCalculator implements CostCalculator {

    private static final int TWO_FOR_ONE = 2;
    private static final Integer THREE_FOR_TWO = 3;

    @Override
    public double calculateCost(Apple apple) {
        // TODO Auto-generated method stub
        return (apple.getQuantity() * FruitType.APPLE.getUnitCost())
                - (Integer.valueOf((apple.getQuantity()/TWO_FOR_ONE))*FruitType.APPLE.getUnitCost());
    }

    @Override
    public double calculateCost(Orange orange) {
        return (orange.getQuantity() * FruitType.ORANGE.getUnitCost())
                - (Integer.valueOf((orange.getQuantity()/THREE_FOR_TWO))*FruitType.ORANGE.getUnitCost());
    }

}
