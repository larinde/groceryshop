/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.domain.service;

import com.koweg.grocery.domain.model.Apple;
import com.koweg.grocery.domain.model.Orange;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public interface CostCalculator {

    public double calculateCost(Apple apple);

    public double calculateCost(Orange orange);

}
