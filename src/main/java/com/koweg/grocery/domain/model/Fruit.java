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
public class Fruit implements CostFunction {

    private final FruitType fruitType;
    private final Integer quantity;

    public Fruit(FruitType fruitType, Integer quantity) {
        super();
        this.fruitType = fruitType;
        this.quantity = quantity;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public double getCost(CostCalculator calculator) {
        return calculator.calculateCost(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fruitType == null) ? 0 : fruitType.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fruit other = (Fruit) obj;
        if (fruitType != other.fruitType)
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Fruit [fruitType=" + fruitType + ", quantity=" + quantity + "]";
    }

}
