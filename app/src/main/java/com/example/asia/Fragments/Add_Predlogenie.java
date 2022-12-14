package com.example.asia.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.asia.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add_Predlogenie#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_Predlogenie extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
ImageButton next;
    public Add_Predlogenie() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Add_Predlogenie.
     */
    // TODO: Rename and change types and number of parameters
    public static Add_Predlogenie newInstance(String param1, String param2) {
        Add_Predlogenie fragment = new Add_Predlogenie();
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

        View inflatedView = inflater.inflate(R.layout.fragment_add__predlogenie, container, false);
        next = (ImageButton) inflatedView.findViewById(R.id.NextMenuAdminPredlogenie);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                AdminMenu fragment = new AdminMenu();
                ft.replace(R.id.containerAdmin, fragment);
                ft.commit();
            }
        });

        return inflatedView;

    }
}