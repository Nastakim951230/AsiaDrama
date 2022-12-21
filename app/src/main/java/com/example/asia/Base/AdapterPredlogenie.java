package com.example.asia.Base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asia.R;

import java.util.List;

public class AdapterPredlogenie extends BaseAdapter {
    private Context nContext;

    public AdapterPredlogenie(Context nContext, List<MaskaPredlogenie> maskaKinoList)
    {
        this .nContext=nContext;
        this.maskaKinoList=maskaKinoList;
    }
    List<MaskaPredlogenie> maskaKinoList;

    @Override
    public int getCount() {
        return maskaKinoList.size();
    }

    @Override
    public Object getItem(int i) {
        return maskaKinoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return maskaKinoList.get(i).getIdSentence();
    }

    private Bitmap getUserImage(String encodedImg)
    {
        byte[] bytes;
        if(encodedImg!=null&& !encodedImg.equals("null")) {
            bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else
        {

            return BitmapFactory.decodeResource(nContext.getResources(), R.drawable.picture);
        }
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(nContext,R.layout.mask_sentences, null);
        ImageView Image=v.findViewById(R.id.kinoImageSet);
        TextView Name=v.findViewById(R.id.NameKinoSet);
        TextView Year=v.findViewById(R.id.YearKinoSet);
        TextView Ganr=v.findViewById(R.id.Statys);

        MaskaPredlogenie mask=maskaKinoList.get(i);
        Name.setText(mask.getNameKinoAndSerial());
        Year.setText(String.valueOf(mask.getYear()));
        Ganr.setText(mask.getStatys());
        Image.setImageBitmap(getUserImage(mask.getPhotoKinoAndSerial()));



        return v;
    }
}
