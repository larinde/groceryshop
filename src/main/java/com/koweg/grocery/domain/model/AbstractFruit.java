package com.koweg.grocery.domain.model;

public abstract class AbstractFruit implements CostFunction {

    protected final Integer quantity;

    public AbstractFruit(Integer quantity) {
        this.quantity = quantity;
    }

}