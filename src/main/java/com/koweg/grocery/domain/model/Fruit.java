/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.domain.model;

import com.koweg.grocery.domain.service.CostCalculator;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public interface Fruit {
    public double getCost(CostCalculator calculator);

}
