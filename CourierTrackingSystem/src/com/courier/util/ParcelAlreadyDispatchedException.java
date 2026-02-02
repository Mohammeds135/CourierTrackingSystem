package com.courier.util;

public class ParcelAlreadyDispatchedException extends Exception {
    public String toString() {
        return "Parcel already dispatched or not in READY state";
    }
}
