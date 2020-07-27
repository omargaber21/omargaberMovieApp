package com.example.myapplication.ui.ViewModels;

import android.app.Activity;

import com.example.myapplication.data.Repository;
import com.example.myapplication.model.User;

import androidx.lifecycle.ViewModel;

public class RegisterViewModel extends ViewModel {
    public void register(Activity activity, String email, String password){
        Repository.getInstance().register(activity, email, password);
    }
    public void addUser(User user){
        Repository.getInstance().addUser(user);
    }
}
