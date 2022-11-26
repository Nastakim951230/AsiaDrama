package com.example.asia.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.example.asia.R;

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
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Запланировано");
        spec.setContent(R.id.linearLayout2);
        spec.setIndicator("Заплонировано");
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Просмотрено");
        spec.setContent(R.id.linearLayout3);
        spec.setIndicator("Просмотрено");
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Отложено");
        spec.setContent(R.id.linearLayout4);
        spec.setIndicator("Отложено");
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Брошено");
        spec.setContent(R.id.linearLayout5);
        spec.setIndicator("Брошено");
        tabHost.addTab(spec);

        return root;
    }



}