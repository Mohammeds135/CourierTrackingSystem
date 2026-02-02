package com.courier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.courier.bean.Parcel;

public class ParcelDAO {

    public Parcel findParcel(Connection con, String parcelID) throws Exception {

        String sql = "SELECT parcel_id, sender_name, recipient_name, current_status " +
                     "FROM PARCEL_TBL WHERE parcel_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, parcelID);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Parcel parcel = new Parcel();
            parcel.setParcelID(rs.getString("parcel_id"));
            parcel.setSenderName(rs.getString("sender_name"));
            parcel.setRecipientName(rs.getString("recipient_name"));
            parcel.setCurrentStatus(rs.getString("current_status"));
            return parcel;
        }

        return null; 
    }

   
    public boolean updateParcelStatus(Connection con,
                                      String parcelID,
                                      String newStatus) throws Exception {

        String sql = "UPDATE PARCEL_TBL SET current_status = ? WHERE parcel_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, newStatus);
        ps.setString(2, parcelID);

        int rows = ps.executeUpdate();
        return rows > 0;
    }

    public boolean insertParcel(Connection con, Parcel parcel) throws Exception {

        String sql = "INSERT INTO PARCEL_TBL " +
                     "(parcel_id, sender_name, recipient_name, origin, destination, weight, dimensions, current_status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, parcel.getParcelID());
        ps.setString(2, parcel.getSenderName());
        ps.setString(3, parcel.getRecipientName());
        ps.setString(8, parcel.getCurrentStatus());

        return ps.executeUpdate() > 0;
    }

   
    public boolean deleteParcel(Connection con, String parcelID) throws Exception {

        String sql = "DELETE FROM PARCEL_TBL WHERE parcel_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, parcelID);

        return ps.executeUpdate() > 0;
    }
}
