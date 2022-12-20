package com.example.asia.Base;

import java.util.Date;

public class ModelActor {
    private String NameActor;
    private Date DR_Actor;
    private  String PhotoActor;

    public ModelActor(String nameActor, Date DR_Actor, String photoActor) {
        NameActor = nameActor;
        this.DR_Actor = DR_Actor;
        PhotoActor = photoActor;
    }

    public String getNameActor() {
        return NameActor;
    }

    public Date getDR_Actor() {
        return DR_Actor;
    }

    public String getPhotoActor() {
        return PhotoActor;
    }

    public void setNameActor(String nameActor) {
        NameActor = nameActor;
    }

    public void setDR_Actor(Date DR_Actor) {
        this.DR_Actor = DR_Actor;
    }

    public void setPhotoActor(String photoActor) {
        PhotoActor = photoActor;
    }
}
