package com.example.asia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asia.Base.ModelUsers;
import com.example.asia.Base.RetrofitAPI;
import com.example.asia.Base.UsersModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    public void perehod(View v)
    {
        Intent intent = new Intent( this, Input.class);
        startActivity(intent);
    }
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
        if(nickname.replaceAll("\\s+", " ").equals(""))
        {
            Toast.makeText(this, "Nickname не может быть пустым", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            postDataUser(nickname,login,password);
        }
    }

   private void callRegistration()
    {

        String login = String.valueOf(etLogin.getText());
        String password = String.valueOf(etPassword.getText());
        String nickname=String.valueOf((etNickname.getText()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<Boolean> call = retrofitAPI.examinationRegistration(login);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(Registrasua.this, "При регистрации возникла ошибка 1", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(response.body().equals(false))
                {
                    postDataUser(nickname,login, password);
                }
                else
                {
                    Toast.makeText(Registrasua.this, "Произошла ошибка, выберите другой Логин", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(Registrasua.this, "При регистрации возникла ошибка: 2" + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }
    private void postDataUser(String nickname,String login, String password) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        UsersModel modal = new UsersModel(nickname, login, password, null, 2);

        Call<UsersModel> call = retrofitAPI.createUser(modal);

        call.enqueue(new Callback<UsersModel>() {
            @Override
            public void onResponse(Call<UsersModel> call, Response<UsersModel> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(Registrasua.this, "При регистрации пользователя возникла ошибка 3", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Registrasua.this, "Пользователь успешно зарегистрирован", Toast.LENGTH_LONG).show();
                Intent intent = new Intent( Registrasua.this, Input.class);
                startActivity(intent);


            }
            @Override
            public void onFailure(Call<UsersModel> call, Throwable t) {
                Toast.makeText(Registrasua.this, "При регистрации пользователя возникла ошибка: 4" + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}