package com.projects.marketplace.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.projects.marketplace.R;
import com.projects.marketplace.model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {

    private List<Article> cartItemList;

    public CartItemAdapter(List<Article> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public void setCartItemList(List<Article> cartItemList) {
        this.cartItemList = cartItemList;
        notifyDataSetChanged();
    }

    public List<Article> getCartItemList() {
        return cartItemList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemNameTextView;
        TextView fornisseurNameTextView;
        TextView itemPriceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemNameTextView = itemView.findViewById(R.id.itemName);
            fornisseurNameTextView = itemView.findViewById(R.id.fornisseurName);
            itemPriceTextView = itemView.findViewById(R.id.itemPrice);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article cartItem = cartItemList.get(position);

        // Load image using Picasso
        Picasso.get().load(cartItem.getImage()).into(holder.itemImage);

        // Set text values
        holder.itemNameTextView.setText(cartItem.getTitle());
        holder.fornisseurNameTextView.setText(cartItem.getCategory());
        holder.itemPriceTextView.setText(String.format("%s$", cartItem.getPrice()));
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }
}
