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
import android.widget.TabHost;
import android.widget.Toast;

import com.example.asia.Base.AdapterKinoIzbrannoe;
import com.example.asia.Base.KInoIzbrannoeModel;
import com.example.asia.Base.MaskaKinoIzbrannoe;
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
 * Use the {@link Brohenno#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Brohenno extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<MaskaKinoIzbrannoe> listKinoIzbrannoe=new ArrayList<>();
    public static KInoIzbrannoeModel userModel;
    GridView smotr;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Brohenno() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Brohenno.
     */
    // TODO: Rename and change types and number of parameters
    public static Brohenno newInstance(String param1, String param2) {
        Brohenno fragment = new Brohenno();
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
        View root= inflater.inflate(R.layout.fragment_brohenno, container, false);




        smotr=root.findViewById(R.id.ListDramaSmotr);


        GridView KinoListOsmotr = root.findViewById(R.id.ListDramaBrohenno);
        pAdapter = new AdapterKinoIzbrannoe(getActivity(), listKinoIzbrannoe);
        KinoListOsmotr.setAdapter(pAdapter);
        smotr=root.findViewById(R.id.ListDramaBrohenno);
        smotr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                int index=(int) id;

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/KinoAndGroups/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
                Call<KInoIzbrannoeModel> call = retrofitAPI.getIzbrannoe(index);
                call.enqueue(new Callback<KInoIzbrannoeModel>() {
                    @Override
                    public void onResponse(Call<KInoIzbrannoeModel> call, Response<KInoIzbrannoeModel> response) {

                        if(!response.isSuccessful())
                        {
                            Toast.makeText(getActivity(), "При выводе данных возникла ошибка", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        userModel = new KInoIzbrannoeModel(0,response.body().getIdKino());
                        int ig_kino=response.body().getIdKino();

                        FragmentTransaction ft=getFragmentManager().beginTransaction();
                        KinoAndSerialIzbrannoe frafment= new KinoAndSerialIzbrannoe(ig_kino);
                        ft.replace(R.id.contenerIzbrannoe,frafment);
                        ft.commit();
                    }
                    @Override
                    public void onFailure(Call<KInoIzbrannoeModel> call, Throwable t) {
                        Toast.makeText(getActivity(), "При выводе данных возникла ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });


            }
        });
        new GetSmotret().execute();
        return root;

    }

    AdapterKinoIzbrannoe pAdapter;

    private class GetSmotret extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/KinoAndGroups?idGroup=5&idUsers="+ Navigate.index);
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
                    MaskaKinoIzbrannoe tempProduct = new MaskaKinoIzbrannoe(
                            productJson.getInt("IdKinoAndGroups"),
                            productJson.getInt("IdUsers"),
                            productJson.getInt("IdKino"),
                            productJson.getInt("IdGroups"),
                            productJson.getString("Name"),
                            productJson.getInt("YearKinoAndSerial"),
                            productJson.getString("PhotoKinoAndSerial"),
                            productJson.getString("OsnovnoeGanr")

                    );
                    listKinoIzbrannoe.add(tempProduct);
                    pAdapter.notifyDataSetInvalidated();
                }

            }
            catch (Exception ignored)
            {

            }
        }


    }

}