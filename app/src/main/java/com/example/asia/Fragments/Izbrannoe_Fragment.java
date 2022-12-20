package com.example.asia.Fragments;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.asia.Base.AdapterKino;
import com.example.asia.Base.AdapterKinoIzbrannoe;
import com.example.asia.Base.KInoIzbrannoeModel;
import com.example.asia.Base.MaskaKino;
import com.example.asia.Base.MaskaKinoIzbrannoe;
import com.example.asia.Base.ModelUsers;
import com.example.asia.Base.RetrofitAPI;
import com.example.asia.Navigate;
import com.example.asia.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Izbrannoe_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Izbrannoe_Fragment extends Fragment {

    TabHost tabHost;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Izbrannoe_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Izbrannoe_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Izbrannoe_Fragment newInstance(String param1, String param2) {
        Izbrannoe_Fragment fragment = new Izbrannoe_Fragment();
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

        View root= inflater.inflate(R.layout.fragment_izbrannoe_, container, false);

        tabHost=root.findViewById(R.id.tabhost);
        tabHost.setup();

        //Присваеваем значение ячейкам
        TabHost.TabSpec spec=tabHost.newTabSpec("Смотрю");
        spec.setContent(R.id.linearLayout);
        spec.setIndicator("Смотрю");
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        Smotr frafment= new Smotr();
        ft.replace(R.id.tabHostPerehod,frafment);
        ft.commit();
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Запланировано");
        spec.setContent(R.id.linearLayout2);
        spec.setIndicator("Запланировано");
        FragmentTransaction za=getFragmentManager().beginTransaction();
        Zaplanirovanno frafmentzap= new Zaplanirovanno();
        za.replace(R.id.tabHostPerehodzap,frafmentzap);
        za.commit();
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Просмотрено");
        spec.setContent(R.id.linearLayout3);
        spec.setIndicator("Просмотрено");
        FragmentTransaction pr=getFragmentManager().beginTransaction();
        Prosmotrenno frafmentpr= new Prosmotrenno();
        pr.replace(R.id.tabHostPerehodPros,frafmentpr);
        pr.commit();
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Отложено");
        spec.setContent(R.id.linearLayout4);
        spec.setIndicator("Отложено");
        FragmentTransaction ot=getFragmentManager().beginTransaction();
        Otlogenno frafmentot= new Otlogenno();
        ot.replace(R.id.tabHostPerehodOtloge,frafmentot);
        ot.commit();
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Брошено");
        spec.setContent(R.id.linearLayout5);
        spec.setIndicator("Брошено");
        FragmentTransaction br=getFragmentManager().beginTransaction();
        Brohenno frafmentbr= new Brohenno();
        br.replace(R.id.tabHostPerehodBrohe,frafmentbr);
        br.commit();
        tabHost.addTab(spec);



        return root;
    }





}