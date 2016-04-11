/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.service;

import com.koweg.grocery.domain.model.Apple;
import com.koweg.grocery.domain.model.FruitType;
import com.koweg.grocery.domain.model.Orange;
import com.koweg.grocery.domain.service.CostCalculator;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class BasicCostCalculator implements CostCalculator {

    @Override
    public double calculateCost(Apple apple) {
        return apple.getQuantity() * FruitType.APPLE.getUnitCost();
    }

    @Override
    public double calculateCost(Orange orange) {
        return orange.getQuantity() * FruitType.ORANGE.getUnitCost();
    }

}
