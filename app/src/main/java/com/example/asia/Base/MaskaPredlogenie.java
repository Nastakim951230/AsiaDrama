package com.example.asia.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class MaskaPredlogenie implements Parcelable {
    private int IdSentence;
    private String NameKinoAndSerial;
    private int Year;
    private String PhotoKinoAndSerial;
    private String Statys;

    protected MaskaPredlogenie(Parcel in) {
        IdSentence = in.readInt();
        NameKinoAndSerial = in.readString();
        Year = in.readInt();
        PhotoKinoAndSerial = in.readString();
        Statys = in.readString();
    }

    public MaskaPredlogenie(int idSentence, String nameKinoAndSerial, int year, String photoKinoAndSerial, String statys) {
        IdSentence = idSentence;
        NameKinoAndSerial = nameKinoAndSerial;
        Year = year;
        PhotoKinoAndSerial = photoKinoAndSerial;
        Statys = statys;
    }

    public int getIdSentence() {
        return IdSentence;
    }

    public String getNameKinoAndSerial() {
        return NameKinoAndSerial;
    }

    public int getYear() {
        return Year;
    }

    public String getPhotoKinoAndSerial() {
        return PhotoKinoAndSerial;
    }

    public String getStatys() {
        return Statys;
    }

    public void setIdSentence(int idSentence) {
        IdSentence = idSentence;
    }

    public void setNameKinoAndSerial(String nameKinoAndSerial) {
        NameKinoAndSerial = nameKinoAndSerial;
    }

    public void setYear(int year) {
        Year = year;
    }

    public void setPhotoKinoAndSerial(String photoKinoAndSerial) {
        PhotoKinoAndSerial = photoKinoAndSerial;
    }

    public void setStatys(String statys) {
        Statys = statys;
    }

    public static final Creator<MaskaPredlogenie> CREATOR = new Creator<MaskaPredlogenie>() {
        @Override
        public MaskaPredlogenie createFromParcel(Parcel in) {
            return new MaskaPredlogenie(in);
        }

        @Override
        public MaskaPredlogenie[] newArray(int size) {
            return new MaskaPredlogenie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(IdSentence);
        parcel.writeString(NameKinoAndSerial);
        parcel.writeInt(Year);
        parcel.writeString(PhotoKinoAndSerial);
        parcel.writeString(Statys);
    }
}
