package com.example.hongs.contact.binhpham.objects;

import java.util.Date;

/**
 * Created by phambinh on 2018-03-15.
 *
 */

public class CallHistory {
    private String callName;
    private String phoneNumber;
    private int callType;
    private Date callDate;
    private String callDuration;

    public CallHistory(String callName, String phoneNumber, int callType, Date callDate, String callDuration) {
        this.callName = callName;
        this.phoneNumber = phoneNumber;
        this.callType = callType;
        this.callDate = callDate;
        this.callDuration = callDuration;
    }

    public String getCallName() {
        return callName;
    }

    public void setCallName(String callName) {
        this.callName = callName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }
}
