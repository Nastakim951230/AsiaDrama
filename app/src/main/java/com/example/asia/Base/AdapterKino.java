package com.example.asia.Base;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asia.R;

import java.io.InputStream;
import java.util.List;

public class AdapterKino extends BaseAdapter {

    private Context nContext;

    public AdapterKino(Context nContext,List<MaskaKino> maskaKinoList)
    {
        this.nContext=nContext;
        this.maskaKinoList=maskaKinoList;
    }
    List<MaskaKino> maskaKinoList;

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
        return maskaKinoList.get(i).getId();
    }


    public static Bitmap loadContactPhoto(ContentResolver cr, long id, Context context) {
        Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, id);
        InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(cr, uri);
        if (input == null) {
            Resources res = context.getResources();
            return BitmapFactory.decodeResource(res, R.drawable.picture);
        }
        return BitmapFactory.decodeStream(input);
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

            return BitmapFactory.decodeResource(nContext.getResources(),R.drawable.picture);
        }
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(nContext,R.layout.maska_kino, null);
        ImageView Image=v.findViewById(R.id.kinoImage);
        TextView Name=v.findViewById(R.id.NameKino);
        TextView Year=v.findViewById(R.id.YearKino);
        TextView Ganr=v.findViewById(R.id.GanrKino);

        MaskaKino mask=maskaKinoList.get(i);
        Name.setText(mask.getName());
        Year.setText(mask.getYaer());
        Ganr.setText(mask.getGanger());
        Image.setImageBitmap(getUserImage(mask.getPhotoKino()));
        return v;
    }
}
