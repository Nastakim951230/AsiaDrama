package com.example.asia.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class MaskaKinoIzbrannoe implements Parcelable {

    private int IdKinoAndGroups;
    private int IdUsers;
    private int IdKino;
    private int IdGroups;
    private String Name;
    private  int Yaer;
    private String PhotoKino;
    private String Ganger;
    protected MaskaKinoIzbrannoe(Parcel in) {

        IdKinoAndGroups = in.readInt();
        IdUsers = in.readInt();
        IdKino = in.readInt();
        IdGroups = in.readInt();
        Name = in.readString();
        Yaer = in.readInt();
        PhotoKino = in.readString();
        Ganger = in.readString();
    }

    public void setIdKinoAndGroups(int idKinoAndGroups) {
        IdKinoAndGroups = idKinoAndGroups;
    }

    public void setIdUsers(int idUsers) {
        IdUsers = idUsers;
    }

    public void setIdKino(int idKino) {
        IdKino = idKino;
    }

    public void setIdGroups(int idGroups) {
        IdGroups = idGroups;
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

    public void setGanger(String ganger) {
        Ganger = ganger;
    }

    public int getIdKinoAndGroups() {
        return IdKinoAndGroups;
    }

    public int getIdUsers() {
        return IdUsers;
    }

    public int getIdKino() {
        return IdKino;
    }

    public int getIdGroups() {
        return IdGroups;
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

    public String getGanger() {
        return Ganger;
    }

    public MaskaKinoIzbrannoe(int idKinoAndGroups, int idUsers, int idKino, int idGroups, String name,  int yaer,  String photoKino, String ganger) {
        IdKinoAndGroups = idKinoAndGroups;
        IdUsers = idUsers;
        IdKino = idKino;
        IdGroups = idGroups;
        Name = name;
        Yaer = yaer;
        PhotoKino = photoKino;
        Ganger = ganger;
    }

    public static final Creator<MaskaKinoIzbrannoe> CREATOR = new Creator<MaskaKinoIzbrannoe>() {
        @Override
        public MaskaKinoIzbrannoe createFromParcel(Parcel in) {
            return new MaskaKinoIzbrannoe(in);
        }

        @Override
        public MaskaKinoIzbrannoe[] newArray(int size) {
            return new MaskaKinoIzbrannoe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(IdKinoAndGroups);
        parcel.writeInt(IdUsers);
        parcel.writeInt(IdKino);
        parcel.writeInt(IdGroups);
        parcel.writeString(Name);

        parcel.writeInt(Yaer);

        parcel.writeString(PhotoKino);
        parcel.writeString(Ganger);
    }
}
