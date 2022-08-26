package com.example.bankapp.Data;

import com.example.bankapp.Data.local.prefs.PreferencesHelper;
import com.example.bankapp.Data.remote.ApiHelper;
import com.example.bankapp.framework.util.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public interface DataManager extends PreferencesHelper, ApiHelper {
    SchedulerProvider getSchedulerProvider();
    CompositeDisposable getCompositeDisposable();
}
