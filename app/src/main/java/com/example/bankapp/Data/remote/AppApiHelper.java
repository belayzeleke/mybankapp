package com.example.bankapp.Data.remote;

import android.content.Context;

import com.example.bankapp.Data.local.prefs.PreferencesHelper;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppApiHelper implements ApiHelper{
    private final Context mContext;
    private final ApiInterceptor mInterceptor;
    private static Retrofit retrofit=null;
    private  static final int  NETWORK_CALL_TIMEOUT = 90;
    public AppApiHelper(Context context, PreferencesHelper preferencesHelper){
        mContext = context;
        ApiHeader.PublicApiHeader publicApiHeader = new ApiHeader.PublicApiHeader();
        ApiHeader.ProtectedApiHeader protectedApiHeader = new ApiHeader.ProtectedApiHeader(
                preferencesHelper.getAccessToken(),
                preferencesHelper);
        ApiHeader apiHeader = new ApiHeader(publicApiHeader, protectedApiHeader);
        mInterceptor = new ApiInterceptor(apiHeader);
    }
    private APIService getApiService() {
        return getRetrofitInstance().create(APIService.class);
    }

    private OkHttpClient configureTimeouts() {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(mContext.getCacheDir(), cacheSize);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(mInterceptor)
                .addInterceptor(logging)
                .connectTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
                .cache(cache)
                .build();
        return okHttpClient;
    }
//actual API calling function
    private Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
//                    .baseUrl(BuildConfig.BASE_URL)
                    .client(configureTimeouts())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    @Override
    public Observable<okhttp3.Response> performLogin() {
        return getRetrofitInstance().create(APIService.class).performLogin();
    }
}
