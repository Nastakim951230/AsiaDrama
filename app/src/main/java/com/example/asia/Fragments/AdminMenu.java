package com.example.asia.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.asia.Base.ModelActor;
import com.example.asia.Base.ModelGanr;
import com.example.asia.Base.RetrofitAPI;
import com.example.asia.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdminMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdminMenu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button ganr,admin,predlogenie,actor;
    public AdminMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdminMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static AdminMenu newInstance(String param1, String param2) {
        AdminMenu fragment = new AdminMenu();
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
        View inflatedView = inflater.inflate(R.layout.fragment_admin_menu, container, false);
        predlogenie = (Button) inflatedView.findViewById(R.id.AddPredlogenie);
        ganr= (Button) inflatedView.findViewById(R.id.AddGenre);
        admin= (Button) inflatedView.findViewById(R.id.AddAdmin);
        actor= (Button) inflatedView.findViewById(R.id.AddActor);
       predlogenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Add_Predlogenie fragment = new Add_Predlogenie();
                ft.replace(R.id.containerAdmin, fragment);
                ft.commit();
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                SpisokAdmin fragment = new SpisokAdmin();
                ft.replace(R.id.containerAdmin, fragment);
                ft.commit();
            }
        });
        actor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Add_Actor fragment = new Add_Actor();
                ft.replace(R.id.containerAdmin, fragment);
                ft.commit();
            }
        });
        ganr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final View customLayout = getLayoutInflater().inflate(R.layout.name_ganr, null);
                new AlertDialog.Builder(getParentFragment().getActivity())
                        .setTitle("Жанр").setView(customLayout)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        EditText editText = customLayout.findViewById(R.id.NameGanr);
                        sendDialogDataToActivity(editText.getText().toString());
                    }
                            private void sendDialogDataToActivity(String ganr) {
                                postAdd(ganr);
                            }
                }).show();
            }
        });
        return inflatedView;

    }
    private void postAdd(String ganr)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        ModelGanr modal = new ModelGanr(ganr);
            Call<ModelGanr> call = retrofitAPI.createPost(modal);
            call.enqueue(new Callback<ModelGanr>() {
                @Override
                public void onResponse(Call<ModelGanr> call, Response<ModelGanr> response) {
                    Toast.makeText(getActivity(), "Запись добавлена", Toast.LENGTH_SHORT).show();

                    ModelGanr responseFromAPI = response.body();
                }

                @Override
                public void onFailure(Call<ModelGanr> call, Throwable t) {

                }
            });
    }
}