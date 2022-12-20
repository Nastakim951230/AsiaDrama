package com.example.asia.Base;

public class ModelUsers {
    private int IdUser;
    private String Nickname;
    private String Login;
    private String Password;
    private String PhotoUsers;
    private int Role;

    public ModelUsers(int idUser, String nickname, String login, String password, String photoUsers, int role) {
        IdUser = idUser;
        Nickname = nickname;
        Login = login;
        Password = password;
        PhotoUsers = photoUsers;
        Role = role;
    }

    public int getIdUser() {
        return IdUser;
    }

    public String getNickname() {
        return Nickname;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhotoUsers() {
        return PhotoUsers;
    }

    public int getRole() {
        return Role;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhotoUsers(String photoUsers) {
        PhotoUsers = photoUsers;
    }

    public void setRole(int role) {
        Role = role;
    }
}
