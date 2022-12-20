package com.example.asia.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asia.Base.AdapterGanre;
import com.example.asia.Base.AdapterKino;
import com.example.asia.Base.CountryModel;
import com.example.asia.Base.DataModalKino;
import com.example.asia.Base.MaskaGanre;
import com.example.asia.Base.RetrofitAPI;
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


public class KInoAndSerial extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView Banner;
    TextView Title, Country, Yaer, Time,Okino;
    EditText pometki;
    ImageButton next;
    private List<MaskaGanre> listGanre=new ArrayList<>();
    int ID;
    public KInoAndSerial(int id) {
        ID=id;
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
        View view =inflater.inflate(R.layout.fragment_k_ino_and_serial, container, false);


        Banner=view.findViewById(R.id.banner);


        Title=view.findViewById(R.id.title);

        Country=view.findViewById(R.id.countri);
        Yaer=view.findViewById(R.id.year);
        Time=view.findViewById(R.id.time);
        Okino=view.findViewById(R.id.short_descriptions);

     GridView ListGanr = view.findViewById(R.id.ganr);
        AdapterGanr = new AdapterGanre(getActivity(), listGanre);
        ListGanr.setAdapter(AdapterGanr);

        next = (ImageButton) view.findViewById(R.id.NextGlavnay);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Glavnay_Fragment fragment = new Glavnay_Fragment();
                ft.replace(R.id.contenerGlavnay, fragment);
                ft.commit();
            }
        });
        callGetKinoAndSerial();
        new GetGanr().execute();
        return view;
    }


    AdapterGanre AdapterGanr;

    private class GetGanr extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/KinoAndGenres?idKino="+ID);
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
                    MaskaGanre Ganr = new MaskaGanre(

                            productJson.getInt("IdKinoAndGenre"),
                            productJson.getInt("idKino"),
                            productJson.getString( "idGenre")
                    );
                    listGanre.add(Ganr);
                    AdapterGanr.notifyDataSetInvalidated();
                }

            }
            catch (Exception ignored)
            {

            }
        }
    }
    public void callGetKinoAndSerial()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/ТрифоноваАР/api/KinoAndSerials/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

       Call<DataModalKino> call = retrofitAPI.getDATAKinoAndSerial(ID);
        call.enqueue(new Callback<DataModalKino>() {
            @Override
            public void onResponse(Call<DataModalKino> call, Response<DataModalKino> response) {

                if(!response.isSuccessful())
                {
                    Toast.makeText(getActivity(), "При выводе данных возникла ошибка", Toast.LENGTH_SHORT).show();
                    return;
                }
                Title.setText(response.body().getName());
                Okino.setText(response.body().getOKinoAndSerial());
                Time.setText(response.body().getTimeKinoAndSerial());
                Yaer.setText(String.valueOf(response.body().getYearKinoAndSerial()));


                if(response.body().getPhotoKinoAndSerial() == null)
                {
                    Banner.setImageResource(R.drawable.picture);

                }
                else
                {
                    Bitmap bitmap = StringToBitMap(response.body().getPhotoKinoAndSerial());
                    Banner.setImageBitmap(bitmap);

                }



                callGetCountry(response.body().getIdCountry());
            }
            @Override
            public void onFailure(Call<DataModalKino> call, Throwable t) {
                Toast.makeText(getActivity(), "При выводе данных возникла ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    public void callGetCountry(int id_country)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/Countries/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<CountryModel> call = retrofitAPI.getCountries(id_country);
        call.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {

                if(!response.isSuccessful())
                {
                    Toast.makeText(getActivity(), "При выводе страны возникла ошибка", Toast.LENGTH_SHORT).show();
                    return;
                }
                Country.setText(String.valueOf(response.body().getCountries()));
            }
            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {
                Toast.makeText(getActivity(), "При выводе страны возникла ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
  
}