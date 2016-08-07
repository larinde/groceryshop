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
public interface CostCalculator {


    public double calculateCost(Fruit fruit);

}
