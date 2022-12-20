package com.example.asia.Base;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("Users")
    Call<ModelUsers> Login(@Query("Login") String login, @Query("Password") String password);

    @GET("{id}")
    Call<DataModalKino> getDATAKinoAndSerial(@Query("id") int id);

    @GET("{id}")
    Call<CountryModel> getCountries(@Query("id") int id);

    @GET("Users")
    Call<Boolean> examinationRegistration(@Query("Login") String login);

    @POST("Users")
    Call<UsersModel> createUser(@Body UsersModel modelUsers);

    @POST("Actors")
    Call<ModelActor> createPost(@Body ModelActor dataModal);
    @POST("Genres")
    Call<ModelGanr> createPost(@Body ModelGanr dataModal);
    @GET ("Genres")
    Call<ModelGanr> getGanr(@Body ModelGanr dataModal);
}
