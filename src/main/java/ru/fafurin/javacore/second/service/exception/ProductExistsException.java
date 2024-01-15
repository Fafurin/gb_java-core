package ru.fafurin.javacore.second.service.exception;

import ru.fafurin.javacore.second.entity.Product;

public class ProductExistsException extends RuntimeException {

    private final Product product;
    public ProductExistsException(Product product) {
        super();
        this.product = product;
    }

    @Override
    public String getMessage() {
        return "There is no product with the title " + this.product.getTitle();
    }
}
