package com.projects.marketplace.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Cart class
public class Cart implements Serializable {
    private List<Article> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public List<Article> getCartItems() {
        return cartItems;
    }

    public void addItem(Article item) {
        cartItems.add(item);
    }

    // Add other methods as needed
}
