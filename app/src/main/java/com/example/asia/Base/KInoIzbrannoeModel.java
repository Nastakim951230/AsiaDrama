package com.example.asia.Base;

public class KInoIzbrannoeModel {
    private int IdKinoAndGroups;

    private int IdKino;

    public KInoIzbrannoeModel(int idKinoAndGroups, int idKino) {
        IdKinoAndGroups = idKinoAndGroups;
        IdKino = idKino;
    }

    public int getIdKinoAndGroups() {
        return IdKinoAndGroups;
    }

    public int getIdKino() {
        return IdKino;
    }

    public void setIdKinoAndGroups(int idKinoAndGroups) {
        IdKinoAndGroups = idKinoAndGroups;
    }

    public void setIdKino(int idKino) {
        IdKino = idKino;
    }
}
