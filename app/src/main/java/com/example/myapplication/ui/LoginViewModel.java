package com.example.myapplication.ui;

import android.content.Context;

import com.example.myapplication.data.Repository;

import androidx.lifecycle.ViewModel;
public class LoginViewModel extends ViewModel {
public void login(Context context,String email,String password){
    Repository.getInstance().login(context,email,password);
}

}
