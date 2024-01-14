package com.projects.marketplace.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projects.marketplace.R;
import com.projects.marketplace.api.StoreApiClient;
import com.projects.marketplace.model.Article;
import com.projects.marketplace.model.Cart;
import com.projects.marketplace.view.adapters.BottomSectionClickListenerUtil;
import com.projects.marketplace.view.adapters.CartItemAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoppingCartActivity extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private TextView totalPriceTextView;
    private Button checkoutButton;
    private CartItemAdapter cartItemAdapter;
    private Cart shoppingCart;
    private double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        // Initialize UI components
        initUI();

        // Set up RecyclerView for cart items
        setupRecyclerView();

        // Fetch products and update the cart
        fetchProducts();

        // Set onClickListener for the "Checkout" button
        setCheckoutButtonClickListener();

        // Update the total price based on the items in the cart
        updateTotalPrice();

        // Set up bottom section click listeners
        setBottomSectionClickListeners();
    }

    private void initUI() {
        cartRecyclerView = findViewById(R.id.cartItemList);
        totalPriceTextView = findViewById(R.id.totalPriceTextView);
        checkoutButton = findViewById(R.id.btnCheckout);
        shoppingCart = new Cart();
    }

    private void setupRecyclerView() {
        List<Article> cartItems = new ArrayList<>(); // Empty list initially
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartItemAdapter = new CartItemAdapter(cartItems);
        cartRecyclerView.setAdapter(cartItemAdapter);
    }

    private void setCheckoutButtonClickListener() {
        checkoutButton.setOnClickListener(v -> {
            // Implement your checkout logic here
        });
    }

    private void setBottomSectionClickListeners() {
        View bottomSection = findViewById(R.id.bottomSection);
        BottomSectionClickListenerUtil.setButtonClickListeners(this, bottomSection);
    }

    private void updateTotalPrice() {
        double total = calculateTotalPrice();
        String formatedPrice = String.format("%.2f", total);
        totalPriceTextView.setText(String.format("Total Price: $%s", formatedPrice));
    }

    private List<Article> getCartItems() {
        return shoppingCart.getCartItems();
    }

    private double calculateTotalPrice() {
        return totalPrice;
    }

    private void fetchProducts() {
        StoreApiClient.FakeStoreApi api = StoreApiClient.getApi();

        Call<List<Article>> productsCall = api.getProducts();
        productsCall.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (response.isSuccessful()) {
                    List<Article> products = response.body();
                    for (int i = 0; i < 4 && i < products.size(); i++) {
                        Article product = products.get(i);
                        shoppingCart.addItem(product);
                        totalPrice += product.getPrice();
                    }
                    // Update UI or perform other tasks if needed
                    // Notify the adapter of the data change after adding items to the cart
                    cartItemAdapter.setCartItemList(getCartItems());
                    // Update the total price text view
                    updateTotalPrice();
                } else {
                    // TODO: Handle the error
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                // TODO: Handle network failure
            }
        });
    }

}
