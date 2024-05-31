package dev.yamlreader.store;

import java.util.List;

import dev.yamlreader.product.Product;

public record Store(String title, String description, List<Product> products) {
}
