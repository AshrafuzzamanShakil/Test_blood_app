package com.shakil.test_blod.Retrofit;

public class PostPojo {
    private String userId;
    private String name;
    private String address;
    private String phone;
    private String bloodgroup;
    private String discription;
    private String hospital;
    private String image_url;

    public PostPojo(String userId, String name, String address, String phone, String bloodgroup, String discription, String hospital, String image_url) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.bloodgroup = bloodgroup;
        this.discription = discription;
        this.hospital = hospital;
        this.image_url = image_url;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
