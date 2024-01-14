package com.projects.marketplace.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.projects.marketplace.R;
import com.projects.marketplace.view.adapters.BottomSectionClickListenerUtil;


public class RegisterActivity extends AppCompatActivity {

    private EditText name, address, password, passwordConfirmation;
    private Spinner spinnerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        name = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        passwordConfirmation = findViewById(R.id.editTextPasswordConfirmation);
        address = findViewById(R.id.editTextAddress);
        spinnerUser = findViewById(R.id.spinnerUserType);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvLogin = findViewById(R.id.tvLogin);

        View bottomSection = findViewById(R.id.bottomSection);
        BottomSectionClickListenerUtil.setButtonClickListeners(this, bottomSection);

        // Set up user type spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.user_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUser.setAdapter(adapter);

        // Set click listeners
        btnRegister.setOnClickListener(v -> register());

        tvLogin.setOnClickListener(v -> login());
    }

    private void login() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void register() {
        // TODO: Add your registration logic here
        // You can retrieve entered
        String username = name.getText().toString();
//        String password = password.getText().toString();
//        String passwordConfirmation = passwordConfirmation.getText().toString();
//        String address = address.getText().toString();
        String userType = spinnerUser.getSelectedItem().toString();
    }
}
