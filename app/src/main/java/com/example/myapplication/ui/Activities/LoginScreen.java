package com.example.myapplication.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.ui.ViewModels.LoginViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class LoginScreen extends AppCompatActivity {
    TextInputEditText username, password;
    Button loginBtn, registerBtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        username = findViewById(R.id.usernameTIET);
        password = findViewById(R.id.passwordTIET);
        loginBtn = findViewById(R.id.btnLogin);
        registerBtn = findViewById(R.id.btnRegister);
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        registerBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterScreen.class);
            startActivity(intent);
        });
        loginBtn.setOnClickListener(view -> {
            loginViewModel.login(getApplicationContext(), username.getText().toString(), password.getText().toString());
        }
);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
