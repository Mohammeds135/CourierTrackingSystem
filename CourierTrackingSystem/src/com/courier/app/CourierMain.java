package com.courier.app;

import java.util.Date;
import com.courier.service.DispatchService;
import com.courier.bean.Dispatch;
import com.courier.bean.Parcel;

public class CourierMain {

    public static void main(String[] args) {

        DispatchService service = new DispatchService();

        try {
            Dispatch dispatch = service.dispatchParcel(
                    "PCL2025002",
                    "VH1005",
                    new Date(),8
                    new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000)
            );

            Parcel parcel = service.viewParcelDetails(dispatch.getParcelID());

            System.out.println("Customer Name : " + parcel.getSenderName());
            System.out.println("Parcel No     :📦 " + parcel.getParcelID());
            System.out.println("Tracking ID   :✍️ " + dispatch.getDispatchID());
            System.out.println("Vehicle No    :🛻 " + dispatch.getVehicleID());
            System.out.println("Order Status  :👍 " + dispatch.getStatus());
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
