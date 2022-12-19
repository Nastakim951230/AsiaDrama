package com.example.asia.Base;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {
    @GET("{id}")
    Call<DataModalKino> getDATAKinoAndSerial(@Query("id") int id);

    @GET("{id}")
    Call<CountryModel> getCountries(@Query("id") int id);
}
