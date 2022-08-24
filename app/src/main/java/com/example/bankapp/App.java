package com.example.bankapp;

import android.app.Application;
import android.content.Context;

import com.example.bankapp.Data.AppDataManager;
import com.example.bankapp.Data.DataManager;

public class App extends Application {
    private DataManager dataManager;
    private static App instance;
    public static synchronized App getInstance(){
        return instance;
    }
    @Override
    public void onCreate(){
        super.onCreate();

        dataManager = new AppDataManager(this);
        instance = this;
    }
    public DataManager getDataManager(){
        return dataManager;
    }

}
