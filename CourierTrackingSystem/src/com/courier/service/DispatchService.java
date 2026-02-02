package com.courier.service;

import java.util.Date;
import com.courier.bean.Dispatch;
import com.courier.bean.Parcel;

public class DispatchService {

   
    private static int dispatchSeq = 91000;

    
    public Parcel viewParcelDetails(String parcelID) {

        Parcel p = new Parcel();
        p.setParcelID(parcelID);
        p.setSenderName("Ibrahim");
        p.setRecipientName("Saran");
        p.setCurrentStatus("READY");

        return p;
    }

   
    public Dispatch dispatchParcel(String parcelID,
                                   String vehicleID,
                                   Date dispatchedDate,
                                   Date expectedDeliveryDate) throws Exception {

        Parcel parcel = viewParcelDetails(parcelID);

        if (!"READY".equals(parcel.getCurrentStatus())) {
            throw new Exception("Parcel already dispatched");
        }

        int dispatchID = ++dispatchSeq;

       
        Dispatch dispatch = new Dispatch();
        dispatch.setDispatchID(dispatchID);
        dispatch.setParcelID(parcelID);
        dispatch.setVehicleID(vehicleID);
        dispatch.setDispatchedDate(dispatchedDate);
        dispatch.setExpectedDeliveryDate(expectedDeliveryDate);
        dispatch.setStatus("DISPATCHED");

        System.out.println("Parcel " + parcelID + " dispatched using vehicle " + vehicleID);

        return dispatch;
    }
}
