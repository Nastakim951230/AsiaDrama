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

    public AdapterGanre(Context nContext, List<MaskaGanre> maskaGenresList)
    {
        this .nContext=nContext;
        this.maskaGenresList=maskaGenresList;
    }
    List<MaskaGanre> maskaGenresList;

    @Override
    public int getCount() {
        return maskaGenresList.size();
    }

    @Override
    public Object getItem(int i) {
        return maskaGenresList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return maskaGenresList.get(i).getID();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(nContext, R.layout.item_book, null);

        TextView Name=v.findViewById(R.id.GanrNmeKino);
        MaskaGanre mask=maskaGenresList.get(i);
        Name.setText(mask.getGenres());

        return v;
    }
}
