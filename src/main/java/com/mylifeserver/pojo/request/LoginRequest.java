package com.mylifeserver.pojo.request;

public class LoginRequest {
    private String account;
    private String password;
    private String verificationCode;
    private String name;


    public LoginRequest(String account, String password) {
        this.account = account;
        this.password = password;

    }

    public LoginRequest() {
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

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "User [account=" + account + ", password=" + password +"]";
    }
}
