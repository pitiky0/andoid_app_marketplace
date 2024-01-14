package com.projects.marketplace.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import com.projects.marketplace.R;
import com.projects.marketplace.view.AllCategoriesActivity;
import com.projects.marketplace.view.LoginActivity;
import com.projects.marketplace.view.MainActivity;
import com.projects.marketplace.view.ShoppingCartActivity;

public class BottomSectionClickListenerUtil {

    public static void setButtonClickListeners(Context context, View bottomSection) {
        ImageButton btnHome = bottomSection.findViewById(R.id.btnHome);
        ImageButton btnShoppingCart = bottomSection.findViewById(R.id.btnShoppingCart);
        ImageButton btnAccount = bottomSection.findViewById(R.id.btnAccount);
        ImageButton btnAllCategories = bottomSection.findViewById(R.id.btnAllCategories);

        btnHome.setOnClickListener(v -> {
            // Intent to navigate to HomeActivity
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        });

        btnShoppingCart.setOnClickListener(v -> {
            // Intent to navigate to ShoppingCartActivity
            Intent intent = new Intent(context, ShoppingCartActivity.class);
            context.startActivity(intent);
        });

        btnAccount.setOnClickListener(v -> {
            // Intent to navigate to LoginActivity
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
        });

        btnAllCategories.setOnClickListener(v -> {
            // Intent to navigate to AllCategoriesActivity
            Intent intent = new Intent(context, AllCategoriesActivity.class);
            context.startActivity(intent);
        });
    }
}
