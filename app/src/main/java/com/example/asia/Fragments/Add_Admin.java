package com.example.asia.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asia.Base.RetrofitAPI;
import com.example.asia.Base.UsersModel;
import com.example.asia.Input;
import com.example.asia.R;
import com.example.asia.Registrasua;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add_Admin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_Admin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageButton next;
    EditText etPassword, etLogin, etNickname;
    ImageView photo;
    Button addAdmin;
    public Add_Admin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Add_Admin.
     */
    // TODO: Rename and change types and number of parameters
    public static Add_Admin newInstance(String param1, String param2) {
        Add_Admin fragment = new Add_Admin();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_add__admin, container, false);

        photo=inflatedView.findViewById(R.id.Image_Admin);
        etLogin=inflatedView.findViewById(R.id.Login_Admin);
        etNickname=inflatedView.findViewById(R.id.Name_Admin);
        etPassword=inflatedView.findViewById(R.id.Password_Admin);

        addAdmin=inflatedView.findViewById(R.id.btnAddAdmin);
        addAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextRegistrarion();
            }
        });

        next = (ImageButton) inflatedView.findViewById(R.id.NextMenuAdminAdmin);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                SpisokAdmin fragment = new SpisokAdmin();
                ft.replace(R.id.containerAdmin, fragment);
                ft.commit();
            }
        });
        return inflatedView;

    }

    public void nextRegistrarion()
    {
        String login = String.valueOf(etLogin.getText());
        String password = String.valueOf(etPassword.getText());
        String nickname = String.valueOf(etNickname.getText());
        if(login.replaceAll("\\s+", " ").equals(""))
        {
            Toast.makeText(getActivity(),"Логин не может быть пустым", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.replaceAll("\\s+", " ").equals(""))
        {
            Toast.makeText(getActivity(),"Пароль не может быть пустым", Toast.LENGTH_SHORT).show();
            return;
        }
        if(nickname.replaceAll("\\s+", " ").equals(""))
        {
            Toast.makeText(getActivity(), "Nickname не может быть пустым", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            postDataUser(nickname,login,password);
        }
    }
   private void postDataUser(String nickname,String login, String password) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        UsersModel modal = new UsersModel(nickname, login, password, null, 1);

        Call<UsersModel> call = retrofitAPI.createUser(modal);

        call.enqueue(new Callback<UsersModel>() {
            @Override
            public void onResponse(Call<UsersModel> call, Response<UsersModel> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getActivity(), "При регистрации пользователя возникла ошибка 3", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getActivity(), "Пользователь успешно зарегистрирован", Toast.LENGTH_LONG).show();
                Intent intent = new Intent( getActivity(), Input.class);
                startActivity(intent);


            }
            @Override
            public void onFailure(Call<UsersModel> call, Throwable t) {
                Toast.makeText(getActivity(), "При регистрации пользователя возникла ошибка: 4" + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}