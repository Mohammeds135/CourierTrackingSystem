package com.courier.util;

public class ActiveDispatchException extends Exception {
    public String toString() {
        return "Parcel has active dispatch or tracking records";
    }
}
