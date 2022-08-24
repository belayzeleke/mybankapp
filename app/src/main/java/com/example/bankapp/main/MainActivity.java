package com.example.bankapp.main;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bankapp.databinding.ActivityMainBinding;


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
//        textView.setText("Belay");
//        textView.setOnClickListener(view -> {
//            textView.setText("Zeleke");
//        });
    }

}
