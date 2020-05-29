package com.example.testapi;

import org.json.JSONException;
import org.json.JSONObject;

public class Data {
    int id;
    String name,userName,email,street,city;

    public Data(JSONObject jsonObject){
        try {
            if (jsonObject.has("id")){
                id = jsonObject.getInt("id");
            }
            if (jsonObject.has("name")) {
                name = jsonObject.getString("name");
            }if (jsonObject.has("username")){
                userName = jsonObject.getString("username");
            }if (jsonObject.has("email")){
                email =jsonObject.getString("email");
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
