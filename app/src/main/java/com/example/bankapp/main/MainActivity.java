package com.example.bankapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bankapp.databinding.ActivityMainBinding;
import com.example.bankapp.login.LoginActivity;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // final TextView textView= binding.textMain;
        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.txtName.observe(this, binding.textMain::setText);

        binding.textMain.setOnClickListener(view -> {
            mainViewModel.onClickName();
        });

        binding.btngotologin.setOnClickListener(view -> openLogin());
//
    }

    private void openLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
