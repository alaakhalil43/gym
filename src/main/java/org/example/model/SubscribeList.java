package org.example.model;

import java.sql.Date;

public class SubscribeList {

    public int id;
    public String member_id;
    public String SubType;
    public int price;
    public String date_start;

    public SubscribeList(String id, String member_id, String subType, int price, Date date_start) {
        this.id = Integer.parseInt(id);
        this.member_id = String.valueOf(member_id);
        SubType = subType;
        this.price = price;
        this.date_start = String.valueOf(date_start);
    }

//    public SubscribeList(int id, String member_id, String subType, int price, Date date_start) {
//        this.id = Integer.parseInt(String.valueOf(id));
//        this.member_id = String.valueOf(Integer.parseInt(member_id));
//        SubType = String.valueOf(Integer.parseInt(subType));
//        this.price = Integer.parseInt(String.valueOf(price));
//        this.date_start = String.valueOf(date_start);
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMember_id(int member_id) {
        this.member_id = String.valueOf(member_id);
    }

    public void setSubType(int subType) {
        SubType = String.valueOf(subType);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDate_start(int date_start) {
        this.date_start = String.valueOf(date_start);
    }

    public int getId() {
        return id;
    }

    public String getMember_id() {
        return member_id;
    }

    public String getSubType() {
        return SubType;
    }

    public int getPrice() {
        return price;
    }

    public String getDate_start() {
        return date_start;
    }
}
