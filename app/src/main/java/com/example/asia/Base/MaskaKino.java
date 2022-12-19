package com.example.asia.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class MaskaKino implements Parcelable {

    private int Id;
    private String Name;
    private String Country;
    private  int Yaer;
    private String Time;
    private String Okino;
    private String PhotoKino;
    private String Ganger;


    public MaskaKino(int id, String name, String country, int yaer, String time, String okino, String photoKino, String ganger) {
        Id = id;
        Name = name;
        Country = country;
        Yaer = yaer;
        Time = time;
        Okino = okino;
        PhotoKino = photoKino;
        Ganger = ganger;
    }

    protected MaskaKino(Parcel in) {
        Id = in.readInt();
        Name = in.readString();
        Country = in.readString();
        Yaer = in.readInt();
        Time = in.readString();
        Okino = in.readString();
        PhotoKino = in.readString();
        Ganger = in.readString();
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setYaer(int yaer) {
        Yaer = yaer;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setOkino(String okino) {
        Okino = okino;
    }

    public void setPhotoKino(String photoKino) {
        PhotoKino = photoKino;
    }

    public void setGanger(String ganger) {
        Ganger = ganger;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }

    public int getYaer() {
        return Yaer;
    }

    public String getTime() {
        return Time;
    }

    public String getOkino() {
        return Okino;
    }

    public String getPhotoKino() {
        return PhotoKino;
    }

    public String getGanger() {
        return Ganger;
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
        parcel.writeString(Country);
        parcel.writeInt(Yaer);
        parcel.writeString(Time);
        parcel.writeString(Okino);
        parcel.writeString(PhotoKino);
        parcel.writeString(Ganger);
    }
}
