package com.mylifeserver.pojo;

public class User {
    private String account;
    private String password;
    private int gender;
    private int available;
    private String name;
    private String image;

    public User(String account, String password, int available,int gender,String name) {
        this.account = account;
        this.password = password;
        this.available = available;
        this.gender = gender;
        this.name=name;
    }

    public User() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String toString() {
        return "User [account=" + account + ", password=" + password + ", available="
                + available + ", gender=" + gender +", name=" + name +"]";
    }
}
