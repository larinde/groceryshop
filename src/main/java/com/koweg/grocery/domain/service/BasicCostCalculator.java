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
public class BasicCostCalculator implements CostCalculator {

    @Override
    public double calculateCost(Fruit fruit) {
        return fruit.getQuantity() * fruit.getFruitType().getUnitCost();
    }

}
