package com.example.bankapp.Data.remote;


import io.reactivex.Observable;
import okhttp3.Response;
import retrofit2.http.POST;

public interface APIService {
//@POST descrip type of post
    @POST(ApiEndPoint.LOGIN)
    Observable<Response> performLogin();

}
