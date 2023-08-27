package org.example.model;

import java.sql.Date;

public class SubscribeList {

    public int id;
    public int member_id;
    public int SubType;
    public int price;
    public String date_start;


    public SubscribeList(int id, int member_id, int subType, int price, Date date_start) {
        this.id = id;
        this.member_id = member_id;
        SubType = subType;
        this.price = price;
        this.date_start = String.valueOf(date_start);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public void setSubType(int subType) {
        SubType = subType;
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

    public int getMember_id() {
        return member_id;
    }

    public int getSubType() {
        return SubType;
    }

    public int getPrice() {
        return price;
    }

    public String getDate_start() {
        return date_start;
    }
}
