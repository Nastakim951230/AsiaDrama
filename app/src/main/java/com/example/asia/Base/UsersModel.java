package com.example.asia.Base;

public class UsersModel {
    private String Nickname;
    private String Login;
    private String Password;
    private String PhotoUsers;
    private int Role;

    public UsersModel(String nickname, String login, String password, String photoUsers, int role) {
        Nickname = nickname;
        Login = login;
        Password = password;
        PhotoUsers = photoUsers;
        Role = role;
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
