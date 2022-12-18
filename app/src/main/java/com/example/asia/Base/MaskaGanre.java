package com.example.asia.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class MaskaGanre implements Parcelable {
    private int ID;
    private  int idKino;
    private  String  Genres;

    protected MaskaGanre(Parcel in) {
        ID = in.readInt();
        idKino = in.readInt();
        Genres = in.readString();
    }

    public MaskaGanre(int ID, int idKino, String genres) {
        this.ID = ID;
        this.idKino = idKino;
        Genres = genres;
    }

    public int getID() {
        return ID;
    }

    public int getIdKino() {
        return idKino;
    }

    public String getGenres() {
        return Genres;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIdKino(int idKino) {
        this.idKino = idKino;
    }

    public void setGenres(String genres) {
        Genres = genres;
    }

    public static final Creator<MaskaGanre> CREATOR = new Creator<MaskaGanre>() {
        @Override
        public MaskaGanre createFromParcel(Parcel in) {
            return new MaskaGanre(in);
        }

        @Override
        public MaskaGanre[] newArray(int size) {
            return new MaskaGanre[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ID);
        parcel.writeInt(idKino);
        parcel.writeString(Genres);
    }
}
