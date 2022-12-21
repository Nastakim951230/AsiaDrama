package com.example.asia.Base;

public class ModelSentences {
    private String NameKinoAndSerial;
    private int Year;
    private String PhotoKinoAndSerial;
    private int Statys;
    private int idUsers;

    public ModelSentences(String nameKinoAndSerial, int year, String photoKinoAndSerial, int statys, int idUsers) {
        NameKinoAndSerial = nameKinoAndSerial;
        Year = year;
        PhotoKinoAndSerial = photoKinoAndSerial;
        Statys = statys;
        this.idUsers = idUsers;
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

    public int getStatys() {
        return Statys;
    }

    public int getIdUsers() {
        return idUsers;
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

    public void setStatys(int statys) {
        Statys = statys;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }
}
