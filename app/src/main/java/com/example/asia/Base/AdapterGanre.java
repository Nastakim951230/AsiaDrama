package com.example.asia.Base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asia.R;

import java.util.List;

public class AdapterGanre extends BaseAdapter {

    private Context nContext;

    public AdapterGanre(Context nContext, List<MaskaGanre> maskaGenres)
    {
        this .nContext=nContext;
        this.maskaGenres=maskaGenres;
    }
    List<MaskaGanre> maskaGenres;

    @Override
    public int getCount() {
        return maskaGenres.size();
    }

    @Override
    public Object getItem(int i) {
        return maskaGenres.get(i);
    }

    @Override
    public long getItemId(int i) {
        return maskaGenres.get(i).getID();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(nContext, R.layout.item_book, null);

        TextView Name=v.findViewById(R.id.GanrNmeKino);
        MaskaGanre mask=maskaGenres.get(i);
        Name.setText(mask.getGenres());

        return null;
    }
}
