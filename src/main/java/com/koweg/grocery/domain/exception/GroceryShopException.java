/**
 * Koweg Software Solutions Limited
 *
 */

package com.koweg.grocery.domain.exception;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
public class GroceryShopException extends RuntimeException {

    private static final long serialVersionUID = -6517930494184240628L;

    public GroceryShopException(String message) {
        super(message);
    }
}
