package com.example.bankapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bankapp.databinding.ActivityLoginBinding;
import com.example.bankapp.databinding.ActivityMainBinding;
import com.example.bankapp.login.ui.LoginViewModel;
import com.example.bankapp.main.MainActivity;


public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
mBinding.btnlogin.setOnClickListener(view -> openMain());
    }
    private void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finishAffinity();//closing activity
    }
}
