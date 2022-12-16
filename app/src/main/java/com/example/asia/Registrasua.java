package com.example.asia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrasua extends AppCompatActivity {

    EditText etPassword, etLogin, etNickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasua);

        etLogin=findViewById(R.id.LoginRegistr);
        etNickname=findViewById(R.id.nickname);
        etPassword=findViewById(R.id.PasswordRegistr);


    }
/*
    public void nextRegistrarion(View v)
    {
        String login = String.valueOf(etLogin.getText());
        String password = String.valueOf(etPassword.getText());
        String nickname = String.valueOf(etNickname.getText());
        if(login.replaceAll("\\s+", " ").equals(""))
        {
            Toast.makeText(this,"Логин не может быть пустым", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.replaceAll("\\s+", " ").equals(""))
        {
            Toast.makeText(this,"Пароль не может быть пустым", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!password.replaceAll("\\s+", " ").equals(""))
        {
            Toast.makeText(this, "Nickname не может быть пустым", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            callRegistration();
        }
    }

    private void callRegistration()
    {

        String login = String.valueOf(etLogin.getText());
        String password = String.valueOf(etPassword.getText());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/users")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<Boolean> call = retrofitAPI.examinationRegistration(login);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(Registrasua.this, "При регистрации возникла ошибка", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(response.body().equals(false))
                {
                    postDataUser(login, password);
                }
                else
                {
                    Toast.makeText(Registrasua.this, "Пользователь с таким логиным уже зарегистрирован", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(Registrasua.this, "При авторизации возникла ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
    private void postDataUser(String login, String password) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/ПигалевЕД/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        UserModel modal = new UserModel(login, password, null, 2);

        Call<UserModel> call = retrofitAPI.createUser(modal);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(Registration.this, "При регистрации пользователя возникла ошибка", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Registration.this, "Пользователь успешно зарегистрирован", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
                Intent myIntent = new Intent(Registration.this, Login.class);
                Registration.this.startActivity(myIntent);
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(Registration.this, "При регистрации пользователя возникла ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }*/
    public void perehod(View v)
    {
        Intent intent = new Intent( this, Input.class);
        startActivity(intent);
    }
}