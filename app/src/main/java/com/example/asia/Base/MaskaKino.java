package com.example.asia.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class MaskaKino implements Parcelable {

    private int Id;
    private String Name;
    private  int Yaer;
    private String PhotoKino;

    public MaskaKino(int id, String name, int yaer, String photoKino) {
        Id = id;
        Name = name;
        Yaer = yaer;
        PhotoKino = photoKino;
    }



    protected MaskaKino(Parcel in) {
        Id = in.readInt();
        Name = in.readString();
        Yaer = in.readInt();
        PhotoKino = in.readString();

    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setYaer(int yaer) {
        Yaer = yaer;
    }

    public void setPhotoKino(String photoKino) {
        PhotoKino = photoKino;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getYaer() {
        return Yaer;
    }

    public String getPhotoKino() {
        return PhotoKino;
    }

    public static final Creator<MaskaKino> CREATOR = new Creator<MaskaKino>() {
        @Override
        public MaskaKino createFromParcel(Parcel in) {
            return new MaskaKino(in);
        }

        @Override
        public MaskaKino[] newArray(int size) {
            return new MaskaKino[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Id);
        parcel.writeString(Name);

        parcel.writeInt(Yaer);

        parcel.writeString(PhotoKino);

    }
}
