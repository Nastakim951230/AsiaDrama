package com.example.asia.Base;

public class DataModalKino {
    private String Name;
    private int idCountry;
    private  int YearKinoAndSerial;
    private String TimeKinoAndSerial;
    private String OKinoAndSerial;
    private String PhotoKinoAndSerial;
    private int OsnovnoeGanr;

    public DataModalKino(String name, int idCountry, int yearKinoAndSerial, String timeKinoAndSerial, String OKinoAndSerial, String photoKinoAndSerial, int osnovnoeGanr) {
        Name = name;
        this.idCountry = idCountry;
        YearKinoAndSerial = yearKinoAndSerial;
        TimeKinoAndSerial = timeKinoAndSerial;
        this.OKinoAndSerial = OKinoAndSerial;
        PhotoKinoAndSerial = photoKinoAndSerial;
        OsnovnoeGanr = osnovnoeGanr;
    }

    public String getName() {
        return Name;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public int getYearKinoAndSerial() {
        return YearKinoAndSerial;
    }

    public String getTimeKinoAndSerial() {
        return TimeKinoAndSerial;
    }

    public String getOKinoAndSerial() {
        return OKinoAndSerial;
    }

    public String getPhotoKinoAndSerial() {
        return PhotoKinoAndSerial;
    }

    public int getOsnovnoeGanr() {
        return OsnovnoeGanr;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public void setYearKinoAndSerial(int yearKinoAndSerial) {
        YearKinoAndSerial = yearKinoAndSerial;
    }

    public void setTimeKinoAndSerial(String timeKinoAndSerial) {
        TimeKinoAndSerial = timeKinoAndSerial;
    }

    public void setOKinoAndSerial(String OKinoAndSerial) {
        this.OKinoAndSerial = OKinoAndSerial;
    }

    public void setPhotoKinoAndSerial(String photoKinoAndSerial) {
        PhotoKinoAndSerial = photoKinoAndSerial;
    }

    public void setOsnovnoeGanr(int osnovnoeGanr) {
        OsnovnoeGanr = osnovnoeGanr;
    }
}
