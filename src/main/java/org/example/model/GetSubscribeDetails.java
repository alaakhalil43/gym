package org.example.model;

public class GetSubscribeDetails {
    public int id1;
    public int id2;



    public GetSubscribeDetails(){};
    public GetSubscribeDetails(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId2() {
        return id2;
    }


}
