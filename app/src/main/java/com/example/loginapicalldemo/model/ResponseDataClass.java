package com.example.loginapicalldemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseDataClass {

    @SerializedName("employeeId")
    @Expose
    private Integer employeeId;
    @SerializedName("employeeName")
    @Expose
    private String employeeName;
    @SerializedName("employeeEmail")
    @Expose
    private String employeeEmail;
    @SerializedName("subscriptionId")
    @Expose
    private Integer subscriptionId;
    @SerializedName("subscription")
    @Expose
    private String subscription;
    @SerializedName("verticalId")
    @Expose
    private Integer verticalId;
    @SerializedName("teams")
    @Expose
    private List<Integer> teams = null;
    @SerializedName("screenName")
    @Expose
    private String screenName;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public Integer getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(Integer verticalId) {
        this.verticalId = verticalId;
    }

    public List<Integer> getTeams() {
        return teams;
    }

    public void setTeams(List<Integer> teams) {
        this.teams = teams;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

}
