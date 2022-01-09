package com.example.loginapicalldemo.model;

public class RequestDataClass {

    private String username;
    private String password;
    private int isQRocode;

    public RequestDataClass(String username, String password, int isQRocode) {
        this.username = username;
        this.password = password;
        this.isQRocode = isQRocode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsQRocode() {
        return isQRocode;
    }

    public void setIsQRocode(int isQRocode) {
        this.isQRocode = isQRocode;
    }


}
