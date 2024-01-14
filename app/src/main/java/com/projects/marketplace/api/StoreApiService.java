package com.projects.marketplace.api;

import com.projects.marketplace.model.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StoreApiService {

    @GET("/products")
    Call<List<Article>> getProducts();

    @GET("/products/{id}")
    Call<Article> getProductById(@Path("id") int productId);

    @GET("/products/categories")
    Call<List<String>> getCategories();

    @GET("/products/category/{category}")
    Call<List<Article>> getProductsByCategory(@Path("category") String category);

    @GET("/products")
    Call<List<Article>> getLimitedProducts(@Query("limit") int limit);
}
