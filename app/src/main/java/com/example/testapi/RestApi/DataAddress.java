package com.example.testapi.RestApi;

import org.json.JSONException;
import org.json.JSONObject;

public class DataAddress {
    String street,city;


    public DataAddress(JSONObject jsonObject){

        try {
            if (jsonObject.getJSONObject("address").has("street")){
                street = jsonObject.getJSONObject("address").getString("street");
            }if (jsonObject.getJSONObject("address").has("city")){
                city = jsonObject.getJSONObject("address").getString("city");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
