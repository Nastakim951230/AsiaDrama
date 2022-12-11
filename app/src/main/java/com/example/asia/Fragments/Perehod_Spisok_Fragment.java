package com.example.asia.Fragments;

import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asia.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Perehod_Spisok_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Perehod_Spisok_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Perehod_Spisok_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Perehod_Spisok_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Perehod_Spisok_Fragment newInstance(String param1, String param2) {
        Perehod_Spisok_Fragment fragment = new Perehod_Spisok_Fragment();
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
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        SpiskiFragment fragment = new SpiskiFragment();
        ft.replace(R.id.container, fragment);
        ft.commit();
        return inflater.inflate(R.layout.fragment_perehod__spisok_, container, false);
    }
}