package com.projects.marketplace.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projects.marketplace.R;
import com.projects.marketplace.api.StoreApiClient;
import com.projects.marketplace.model.Article;
import com.projects.marketplace.model.Cart;
import com.projects.marketplace.view.adapters.BottomSectionClickListenerUtil;
import com.projects.marketplace.view.adapters.ItemAdapter;
import com.projects.marketplace.view.adapters.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageButton btnSearch, addToCartButton;
    private List<Article> productList;  // List of products
    private Cart shoppingCart;          // Shopping cart


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        initUI();

        // Setup RecyclerView
        setupRecyclerView();

        // Fetch and display products from the API
        fetchProducts();

        // Set onClickListeners for buttons
        setButtonClickListeners();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
        btnSearch = findViewById(R.id.btnSearch);
        addToCartButton = findViewById(R.id.addToCartButton);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // Display 2 items in each row

        // Create an instance of Cart
        shoppingCart = new Cart();

        // Declare the adapter variable as final
        ItemAdapter adapter = new ItemAdapter(new ArrayList<>(), this);

        recyclerView.setAdapter(adapter);
    }


    private void setButtonClickListeners() {
        // Set up bottom section click listeners
        View bottomSection = findViewById(R.id.bottomSection);
        BottomSectionClickListenerUtil.setButtonClickListeners(this, bottomSection);
        ImageButton btnShoppingCart = bottomSection.findViewById(R.id.btnShoppingCart);


        btnSearch.setOnClickListener(v -> {
            Toast.makeText(this, "Search Button Clicked", Toast.LENGTH_SHORT).show();
            // TODO: Add logic for Search button click
        });
    }

    private void fetchProducts() {
        StoreApiClient.FakeStoreApi api = StoreApiClient.getApi();

        Call<List<Article>> productsCall = api.getProducts();
        productsCall.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (response.isSuccessful()) {
                    List<Article> products = response.body();
                    for (int i = 0; i < 4; i++) {
                        shoppingCart.addItem(products.get(i));
                    }
                    // TODO: Handle the list of products
                    updateRecyclerView(products);
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

    private void updateRecyclerView(List<Article> products) {
        ItemAdapter adapter = (ItemAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItemList(products);
            adapter.notifyDataSetChanged();
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
