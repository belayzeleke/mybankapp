package com.example.bankapp.Data;

import android.content.Context;

import com.example.bankapp.Data.local.prefs.AppPreferencesHelper;
import com.example.bankapp.framework.util.AppConstants;

public class AppDataManager implements DataManager {
    private  AppPreferencesHelper mPrefHelper;
public AppDataManager(Context context){
    mPrefHelper= new AppPreferencesHelper(context, AppConstants.PREF_NAME);
}

    @Override
    public void setLogin(Boolean isLogin) {
mPrefHelper.setLogin(isLogin);
    }

    @Override
    public Boolean getLogin() {
        return mPrefHelper.getLogin();
    }

    @Override
    public void clear() {
mPrefHelper.clear();
    }
}
