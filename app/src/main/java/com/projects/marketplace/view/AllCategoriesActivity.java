package com.projects.marketplace.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.projects.marketplace.R;
import com.projects.marketplace.api.StoreApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCategoriesActivity extends AppCompatActivity {

    private ListView categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        // Initialize UI components
        initUI();

        // Fetch and display categories from the API
        fetchCategories();
    }

    private void initUI() {
        categoryList = findViewById(R.id.categoryList);
    }

    private void fetchCategories() {
        StoreApiClient.FakeStoreApi api = StoreApiClient.getApi();

        Call<List<String>> categoriesCall = api.getCategories();
        categoriesCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    List<String> categories = response.body();
                    displayCategories(categories);
                } else {
                    showToast("Failed to fetch categories");
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                showToast("Network error. Please try again.");
            }
        });
    }

    private void displayCategories(List<String> categories) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        categoryList.setAdapter(adapter);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
