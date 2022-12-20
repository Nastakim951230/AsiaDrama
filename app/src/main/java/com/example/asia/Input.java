package com.example.asia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asia.Base.ModelUsers;
import com.example.asia.Base.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Input extends AppCompatActivity {

    private EditText passwordUser,loginUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        passwordUser=findViewById(R.id.PasswordInput);
        loginUser=findViewById(R.id.LoginInput);
    }
    public void perehod(View v)
    {
        Intent intent = new Intent( this, Registrasua.class);
        startActivity(intent);
    }
    public void iz(View v)
    {
        Intent intent = new Intent( this, Navigate.class);
        startActivity(intent);
    }
/*
    public void login(View v)
    {
        callLogin();
    }

    private void callLogin()
    {

        String login = String.valueOf(loginUser.getText());
        String password = String.valueOf(passwordUser.getText());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<ModelUsers> call = retrofitAPI.Login(login, password);
        call.enqueue(new Callback<ModelUsers>() {
            @Override
            public void onResponse(Call<ModelUsers> call, Response<ModelUsers> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(Input.this, "При авторизации возникла ошибка", Toast.LENGTH_SHORT).show();

                    return;
                }

                if(response.body() != null)
                {
                    if(response.body().getId_role() == 2)
                    {
                        Toast.makeText(Input.this, "Вы успешно авторизировались", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Input.this, Navigate.class);
                        Bundle b = new Bundle();
                        b.putInt("key", response.body().getId_user());
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(Input.this, "Вы вошли как администратор", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Input.this, Navigate.class);
                        startActivity(intent);
                    }
                }
                else
                {
                    Toast.makeText(Input.this, "Пользователь с таким логиным и паролем не найден", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ModelUsers> call, Throwable t) {
                Toast.makeText(Input.this, "При авторизации возникла ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }*/
}