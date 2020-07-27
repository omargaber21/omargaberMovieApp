package com.example.myapplication.ui.Activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.model.User;
import com.example.myapplication.ui.ViewModels.RegisterViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class RegisterScreen extends AppCompatActivity {
    Button btnRegister;
    TextInputEditText email, password,phone,name;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        btnRegister = findViewById(R.id.btnregister);
        email = findViewById(R.id.emailTIET);
        name=findViewById(R.id.nameTIET);
        phone=findViewById(R.id.phoneTIET);
        password = findViewById(R.id.passwordTIET);
        firebaseAuth=FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(view -> {
            if(!validationErrors()){return;}
            RegisterViewModel registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
            User user=new User();
            user.setEmail(email.getText().toString());
            user.setUsername(password.getText().toString());
            user.setPhone(phone.getText().toString());
            registerViewModel.register(RegisterScreen.this, email.getText().toString(), password.getText().toString(),user);
            if(firebaseAuth.getCurrentUser()!=null){
                  finish();
              }
        });
    }
    public boolean validationErrors(){
        boolean b=true;
        if (TextUtils.isEmpty(email.getText())) {
            email.setError("Email is Required");
            b= false;
        }
        if (TextUtils.isEmpty(phone.getText())) {
            phone.setError("Phone is Required");
            b= false;
        }
        if (TextUtils.isEmpty(name.getText())) {
            name.setError("Name is Required");
            b= false;
        }
        if (TextUtils.isEmpty(password.getText())) {
            password.setError("Password is Required");
            b= false;
        }
        if (password.length() < 6) {
            password.setError("Password Must be >= 6 Characters");
            b= false;
        }
        return b;
    }
}
