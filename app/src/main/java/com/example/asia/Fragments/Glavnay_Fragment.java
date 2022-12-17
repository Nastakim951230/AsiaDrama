package com.example.asia.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.asia.Base.AdapterKino;
import com.example.asia.Base.MaskaKino;
import com.example.asia.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Glavnay_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Glavnay_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<MaskaKino> listKino=new ArrayList<>();
    public Glavnay_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Glavnay_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Glavnay_Fragment newInstance(String param1, String param2) {
        Glavnay_Fragment fragment = new Glavnay_Fragment();
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
        View view = inflater.inflate(R.layout.fragment_glavnay_, container, false);
        GridView KinoList = view.findViewById(R.id.ListDrama);
        pAdapter = new AdapterKino(getActivity(), listKino);
        KinoList.setAdapter(pAdapter);
        gridView = view.findViewById(R.id.ListDrama);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int index=(int) id;
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                KInoAndSerial frafment= new KInoAndSerial(index);
                ft.replace(R.id.contenerGlavnay,frafment);
                ft.commit();
            }
        });
        new GetBeutifulPlace().execute();
        return view;

    }



    GridView gridView;
    AdapterKino pAdapter;


    private class GetBeutifulPlace extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://ngknn.ru:5001/NGKNN/ТрифоноваАР/api/KinoAndSerials");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line = "";

                while ((line = reader.readLine()) != null)
                {
                    result.append(line);
                }
                return result.toString();
            }
            catch (Exception exception)
            {
                return null;
            }
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try
            {

                JSONArray tempArray = new JSONArray(s);
                for (int i = 0;i<tempArray.length();i++)
                {
                    JSONObject productJson = tempArray.getJSONObject(i);
                    MaskaKino tempProduct = new MaskaKino(
                            productJson.getInt("IdKinoAndSerial"),
                            productJson.getString("Name"),
                            productJson.getString("idCountry"),
                            productJson.getInt("YearKinoAndSerial"),
                            productJson.getString("TimeKinoAndSerial"),
                            productJson.getString("OKinoAndSerial"),
                            productJson.getString("PhotoKinoAndSerial"),
                            productJson.getString("OsnovnoeGanr")
                    );
                    listKino.add(tempProduct);
                    pAdapter.notifyDataSetInvalidated();
                }

            }
            catch (Exception ignored)
            {

            }
        }
    }

}