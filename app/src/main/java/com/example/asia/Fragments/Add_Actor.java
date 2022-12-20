package com.example.asia.Fragments;

import static android.app.Activity.RESULT_OK;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asia.Base.ModelActor;
import com.example.asia.Base.RetrofitAPI;
import com.example.asia.R;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add_Actor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_Actor extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageButton next;
    TextView dr;
    ImageView image;
    EditText name;
    String img="";
    Button add;
    DatePickerDialog.OnDateSetListener dateSetListener;
    public Add_Actor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Add_Actor.
     */
    // TODO: Rename and change types and number of parameters
    public static Add_Actor newInstance(String param1, String param2) {
        Add_Actor fragment = new Add_Actor();
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
        View inflatedView = inflater.inflate(R.layout.fragment_add__actor, container, false);
        next = (ImageButton) inflatedView.findViewById(R.id.NextMenuAdminActor);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        Calendar calendar=Calendar.getInstance();
        final  int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        image=(ImageView) inflatedView.findViewById(R.id.Image_Actor);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImage();
            }
        });
        name=(EditText) inflatedView.findViewById(R.id.Name_Actor);
        add=(Button) inflatedView.findViewById(R.id.btnAddActor) ;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add();
            }
        });
        dr=(TextView) inflatedView.findViewById(R.id.DR_Actor);
        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(getParentFragment().getActivity(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;

                String date=day+"."+month+"."+year;

                dr.setText(date);
            }
        };

        return inflatedView;

    }

    public void next()
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        AdminMenu fragment = new AdminMenu();
        ft.replace(R.id.containerAdmin, fragment);
        ft.commit();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && data!= null && data.getData()!= null)
        {
            if(resultCode==RESULT_OK)
            {
                Log.d("MyLog","Image URI : "+data.getData());
                image.setImageURI(data.getData());
                Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
                encodeImage(bitmap);

            }
        }
    }

    private void getImage()
    {
        Intent intentChooser= new Intent();
        intentChooser.setType("image/*");
        intentChooser.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentChooser,1);
    }

    private String encodeImage(Bitmap bitmap) {
        int prevW = 150;
        int prevH = bitmap.getHeight() * prevW / bitmap.getWidth();
        Bitmap b = Bitmap.createScaledBitmap(bitmap, prevW, prevH, false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            img= Base64.getEncoder().encodeToString(bytes);
            return img;
        }
        return "";
    }


    public  void Add()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Добвить")
                .setMessage("Вы уверены что хотите добавить данные")
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if ( name.getText().length()==0 ||  dr.getText().length()==0 )
                        {
                            Toast.makeText(getActivity(), "Не заполненны обязательные поля", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            if (img=="")
                            {
                                img=null;
                                postAdd(img,name.getText().toString(),dr.getText().toString());
                            }
                            else
                            {
                                postAdd(img,name.getText().toString(),dr.getText().toString());
                            }
                            SystemClock.sleep(1000);
                            next();
                        }

                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void postAdd(String image, String  name , String dr)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/NGKNN/%D0%A2%D1%80%D0%B8%D1%84%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%90%D0%A0/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        DateFormat date = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date DeniRo = date.parse(dr);
            ModelActor modal = new ModelActor(name,DeniRo,image);

            Call<ModelActor> call = retrofitAPI.createPost(modal);
            call.enqueue(new Callback<ModelActor>() {
                @Override
                public void onResponse(Call<ModelActor> call, Response<ModelActor> response) {
                    Toast.makeText(getActivity(), "Запись добавлена", Toast.LENGTH_SHORT).show();

                    ModelActor responseFromAPI = response.body();
                }

                @Override
                public void onFailure(Call<ModelActor> call, Throwable t) {

                }
            });
        } catch (ParseException e) {

        }




    }

}