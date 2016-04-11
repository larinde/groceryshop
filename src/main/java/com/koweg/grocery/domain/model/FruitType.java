/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.domain.model;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public enum FruitType {

    APPLE(0.60d), ORANGE(0.25d);

    private final double unitCost;

    private FruitType(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getUnitCost() {
        return unitCost;
    }

}