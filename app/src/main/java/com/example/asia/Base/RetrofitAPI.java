package com.example.asia.Base;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {
    @GET("KinoAndSerials/{IdKinoAndSerial}")
    Call<MaskaKino> getDATAKinoAndSerial(@Query("IdKinoAndSerial") int id);
}
