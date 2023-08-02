package org.example.model;

public class MemberList {

  //SELECT id, name, age, phone_num, address, length, weight  FROM member_list;
    private int id;
    private String name;
    private int age;
    private String phone_num;
    private String address;
    private int length;
    private int weight;

    MemberList(){};
    public MemberList(int id, String name, int age, String phone_num, String address, int length, int weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone_num = phone_num;
        this.address = address;
        this.length = length;
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getAddress() {
        return address;
    }

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }
}
