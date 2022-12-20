package com.example.asia.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class MaskaGanre implements Parcelable {
    private int IdKinoAndGenre;
    private  int idKino;
    private  String  idGenre;

    protected MaskaGanre(Parcel in) {
        IdKinoAndGenre = in.readInt();
        idKino = in.readInt();
        idGenre = in.readString();
    }

    public MaskaGanre(int IdKinoAndGenre, int idKino, String idGenre) {
        this.IdKinoAndGenre = IdKinoAndGenre;
        this.idKino = idKino;
        this.idGenre = idGenre;
    }

    public int getID() {
        return IdKinoAndGenre;
    }

    public int getIdKino() {
        return idKino;
    }

    public String getGenres() {
        return idGenre;
    }

    public void setID(int IdKinoAndGenre) {
        this.IdKinoAndGenre = IdKinoAndGenre;
    }

    public void setIdKino(int idKino) {
        this.idKino = idKino;
    }

    public void setGenres(String genres) {
        idGenre = genres;
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
        parcel.writeInt(IdKinoAndGenre);
        parcel.writeInt(idKino);
        parcel.writeString(idGenre);
    }
}
