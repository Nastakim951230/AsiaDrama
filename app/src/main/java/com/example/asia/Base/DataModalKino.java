package com.example.asia.Base;

public class DataModalKino {
    private String Name;
    private int Country;
    private  int Yaer;
    private String Time;
    private String Okino;
    private String PhotoKino;
    private int Ganger;

    public DataModalKino(String name, int country, int yaer, String time, String okino, String photoKino, int ganger) {
        Name = name;
        Country = country;
        Yaer = yaer;
        Time = time;
        Okino = okino;
        PhotoKino = photoKino;
        Ganger = ganger;
    }

    public String getName() {
        return Name;
    }

    public int getCountry() {
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

    public int getGanger() {
        return Ganger;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCountry(int country) {
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

    public void setGanger(int ganger) {
        Ganger = ganger;
    }
}
