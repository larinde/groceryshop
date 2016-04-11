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
public class Orange implements Fruit {

    private final FruitType type = FruitType.ORANGE;

    private final Integer quantity;

    public Orange(Integer quantity) {
        this.quantity = quantity;
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
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Orange other = (Orange) obj;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Orange [quantity=" + quantity + ", type=" + type + "]";
    }

}
