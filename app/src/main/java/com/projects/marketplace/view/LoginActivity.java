package com.projects.marketplace.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.projects.marketplace.R;
import com.projects.marketplace.view.adapters.BottomSectionClickListenerUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView tvRegister = findViewById(R.id.tvRegister);

        View bottomSection = findViewById(R.id.bottomSection);
        BottomSectionClickListenerUtil.setButtonClickListeners(this, bottomSection);

        // Set click listeners
        btnLogin.setOnClickListener(v -> login());

        tvRegister.setOnClickListener(v -> navigateToRegistration());
    }

    private void login() {
        // TODO: Add your login logic here
         String name = editTextUsername.getText().toString();
         String password = editTextPassword.getText().toString();

        // For demonstration, let's navigate to another activity (replace with your logic)
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToRegistration() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}

