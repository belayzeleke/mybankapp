package com.example.bankapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bankapp.App;
import com.example.bankapp.R;
import com.example.bankapp.databinding.ActivityLoginBinding;
import com.example.bankapp.framework.util.AppConstants;
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
        mBinding.btnlogin.setOnClickListener(view -> CheckInput());

if(App.getInstance().getDataManager().getLogin()){
    openMain();
}
    }

    public void CheckInput() {

        if (mBinding.txtusername.getText() == null ||
                mBinding.txtusername.getText().toString().trim().isEmpty()) {
            mBinding.txtusername.setError(getString(R.string.err_username));

        } else if (mBinding.txtpassword.getText() == null ||
                mBinding.txtpassword.getText().toString().trim().isEmpty()) {
            mBinding.txtpassword.setError(getString(R.string.err_password));

        } else if (mBinding.txtusername.getText().toString().equals(AppConstants.USER_NAME) &&
                mBinding.txtpassword.getText().toString().equals(AppConstants.PASSWORD)) {
            App.getInstance().getDataManager().setLogin(mBinding.checkboxLogin.isChecked());

            openMain();
        } else {

            Toast.makeText(this, getString(R.string.err_login), Toast.LENGTH_SHORT).show();
        }
    }

    private void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finishAffinity();//closing activity
    }
}
