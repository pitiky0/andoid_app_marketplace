package com.projects.marketplace.view.adapters;

import android.content.Context;
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

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Article> itemList;
    private Context context;
    private ItemClickListener itemClickListener; // Interface for click events

    // Constructor to initialize the adapter with the data
    public ItemAdapter(List<Article> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public List<Article> getItemList() {
        return itemList;
    }

    public void setItemList(List<Article> itemList) {
        this.itemList = itemList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    // ViewHolder class to hold references to the views in each item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName;
        TextView fornisseurName;
        TextView itemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            fornisseurName = itemView.findViewById(R.id.fornisseurName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
        }
    }

    // Inflate the item layout and create the ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    // Bind data to the views in each item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article currentItem = itemList.get(position);

        // Load image using Picasso
        Picasso.get().load(currentItem.getImage()).into(holder.itemImage);

        // Set text values
        holder.itemName.setText(currentItem.getTitle());
        holder.fornisseurName.setText(currentItem.getCategory());
        holder.itemPrice.setText(String.format("%s$", String.valueOf(currentItem.getPrice())));

        // Set click listener for the "Add to Cart" button
        holder.itemView.findViewById(R.id.addToCartButton).setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onAddToCartClick(position);
            }
        });
    }

    // Return the number of items in the list
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
