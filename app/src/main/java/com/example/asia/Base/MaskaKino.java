package com.example.asia.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class MaskaKino implements Parcelable {

    private int IdKinoAndSerial;
    private String Name;
    private  int YearKinoAndSerial;
    private String PhotoKinoAndSerial;
    private String OsnovnoeGanr;


    public MaskaKino(int id, String name,  int yaer,  String photoKino, String ganger) {
        IdKinoAndSerial = id;
        Name = name;

        YearKinoAndSerial = yaer;

        PhotoKinoAndSerial = photoKino;
        OsnovnoeGanr = ganger;
    }

    protected MaskaKino(Parcel in) {
        IdKinoAndSerial = in.readInt();
        Name = in.readString();

        YearKinoAndSerial = in.readInt();

        PhotoKinoAndSerial = in.readString();
        OsnovnoeGanr = in.readString();
    }

    public void setId(int id) {
        IdKinoAndSerial = id;
    }

    public void setName(String name) {
        Name = name;
    }



    public void setYaer(int yaer) {
        YearKinoAndSerial = yaer;
    }



    public void setPhotoKino(String photoKino) {
        PhotoKinoAndSerial = photoKino;
    }

    public void setGanger(String ganger) {
        OsnovnoeGanr = ganger;
    }

    public int getId() {
        return IdKinoAndSerial;
    }

    public String getName() {
        return Name;
    }


    public int getYaer() {
        return YearKinoAndSerial;
    }


    public String getPhotoKino() {
        return PhotoKinoAndSerial;
    }

    public String getGanger() {
        return OsnovnoeGanr;
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
        parcel.writeInt(IdKinoAndSerial);
        parcel.writeString(Name);

        parcel.writeInt(YearKinoAndSerial);

        parcel.writeString(PhotoKinoAndSerial);
        parcel.writeString(OsnovnoeGanr);
    }
}
