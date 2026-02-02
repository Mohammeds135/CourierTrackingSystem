package com.courier.bean;

public class Parcel {

    private String parcelID;
    private String senderName;
    private String recipientName;
    private String currentStatus;

    public String getParcelID() {
        return parcelID;
    }
    public void setParcelID(String parcelID) {
        this.parcelID = parcelID;
    }

    public String getSenderName() {
        return senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
}
