package com.example.bankapp.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bankapp.App;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> txtName;

    public MainViewModel() {
        txtName = new MutableLiveData<>();
        setName();
    }

    private void setName() {
        String name = "belay";
        if (App.getInstance().getDataManager().getLogin())
            name = "zeleke";
        txtName.setValue(name);


    }

    public void onClickName() {
        Boolean isFather = App.getInstance().getDataManager().getLogin();
        App.getInstance().getDataManager().setLogin(!isFather);
        setName();
    }
}
